package TWITTER;

import jdk.internal.classfile.impl.BlockCodeBuilderImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class TwitterApp {
    private static UserManager userManager;
    private static CuentaUsuario currentUser;

    public static void main(String[] args) {
        userManager = new UserManager();
        // userManager.loadUsersFromFile("users.txt"); // Ya no se necesita

        JFrame frame = new JFrame("Twitter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton addUserButton = new JButton("Registrar nuevo usuario");
        addUserButton.addActionListener(e -> addUser());
        panel.add(addUserButton);

        JButton loadUserButton = new JButton("Cargar usuario en memoria");
        loadUserButton.addActionListener(e -> loadUser());
        panel.add(loadUserButton);

        JButton publishTweetButton = new JButton("Publicar tweet");
        publishTweetButton.addActionListener(e -> publishTweet());
        panel.add(publishTweetButton);

        JButton followUserButton = new JButton("Seguir a un usuario");
        followUserButton.addActionListener(e -> followUser());
        panel.add(followUserButton);

        JButton viewTimelineButton = new JButton("Ver Timeline");
        viewTimelineButton.addActionListener(e -> viewTimeline());
        panel.add(viewTimelineButton);

        JButton sendMessageButton = new JButton("Enviar mensaje directo");
        sendMessageButton.addActionListener(e -> sendDirectMessage());
        panel.add(sendMessageButton);

        JButton sortUsersByEmailButton = new JButton("Ordenar usuarios por email");
        BlockCodeBuilderImpl users = null;
        sortUsersByEmailButton.addActionListener(e -> sortUsersByEmail(users));
        panel.add(sortUsersByEmailButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void addUser() {
        String alias = JOptionPane.showInputDialog(null, "Introduzca el alias del usuario:");
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario:");
        try {
            userManager.addUser(alias, email);
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage());
        }
    }

    private static void loadUser() {
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario a cargar:");
        if (!Utils.isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email no válido.");
            return;
        }

        CuentaUsuario user = userManager.findUserByEmail(email);
        if (user == null) {
            // Si no se encuentra el usuario, preguntar si desea crear uno nuevo.
            int result = JOptionPane.showConfirmDialog(null, "El usuario no existe. ¿Desea crear un nuevo usuario con este email?", "Usuario no encontrado", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String alias = JOptionPane.showInputDialog(null, "Introduzca el alias del nuevo usuario:");
                if (!Utils.isValidAlias(alias)) {
                    JOptionPane.showMessageDialog(null, "Alias no válido.");
                    return;
                }
                try {
                    userManager.addUser(alias, email);
                    user = userManager.findUserByEmail(email);  // Vuelve a buscar el usuario recién creado
                    currentUser = user;
                    JOptionPane.showMessageDialog(null, "Nuevo usuario creado y cargado: " + user.getAlias());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage());
                }
            }
        } else {
            currentUser = user;
            JOptionPane.showMessageDialog(null, "Usuario cargado: " + user.getAlias());
        }
    }



    private static void publishTweet() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario cargado.");
            return;
        }
        String tweetText = JOptionPane.showInputDialog(null, "Introduzca el tweet a publicar:");
        Tweet tweet = new Tweet(tweetText);
        currentUser.tweet(tweet);
        JOptionPane.showMessageDialog(null, "Tweet publicado: " + tweet.getText());
    }

    private static void followUser() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario cargado.");
            return;
        }
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario a seguir:");
        if (!Utils.isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email no válido.");
            return;
        }

        CuentaUsuario userToFollow = userManager.findUserByEmail(email);
        if (userToFollow == null) {
            int reply = JOptionPane.showConfirmDialog(null, "No se encontró al usuario. ¿Desea añadirlo?", "Usuario no encontrado", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                String alias = JOptionPane.showInputDialog(null, "Introduzca el alias del nuevo usuario:");
                if (!Utils.isValidAlias(alias)) {
                    JOptionPane.showMessageDialog(null, "Alias no válido.");
                    return;
                }
                userManager.addUser(alias, email);
                userToFollow = userManager.findUserByEmail(email);
            } else {
                return;
            }
        }

        currentUser.follow(userToFollow);
        JOptionPane.showMessageDialog(null, "Ahora sigues a: " + userToFollow.getAlias());
    }



    private static void viewTimeline() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario cargado.");
            return;
        }
        StringBuilder timelineDetails = new StringBuilder();
        timelineDetails.append("Timeline de ").append(currentUser.getAlias()).append(":\n");

        for (Tweet tweet : currentUser.getTimeline()) {
            timelineDetails.append(tweet.getText()).append(" - @").append(tweet.getUser().getAlias()).append("\n");
        }

        timelineDetails.append("\nSiguiendo a:\n");
        for (CuentaUsuario user : currentUser.getFollowing()) {
            timelineDetails.append(user.getAlias()).append(" (").append(Optional.ofNullable(user.getEmail())).append(")\n");
        }

        JOptionPane.showMessageDialog(null, timelineDetails.toString(), "Timeline y Seguimientos", JOptionPane.INFORMATION_MESSAGE);
    }


    private static void sendDirectMessage() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario cargado.");
            return;
        }
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del destinatario:");
        CuentaUsuario receiver = userManager.findUserByEmail(email);
        if (receiver == null) {
            JOptionPane.showMessageDialog(null, "Usuario destinatario no encontrado.");
            return;
        }
        String message = JOptionPane.showInputDialog(null, "Escribe tu mensaje:");
        DirectMessage dm = new DirectMessage(message, currentUser, receiver);
        currentUser.sendDirectMessage(dm);
        JOptionPane.showMessageDialog(null, "Mensaje enviado a: " + receiver.getAlias());
    }

    private static void sortUsersByEmail(BlockCodeBuilderImpl users) {
        userManager.sortUsersByEmail();
        JOptionPane.showMessageDialog(null, "Usuarios ordenados por email.");
    }
}
