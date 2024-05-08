package TWITTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Optional;

public class TwitterApp {
    private static UserManager userManager;
    private static CuentaUsuario currentUser;

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to the default look and feel.
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        userManager = new UserManager();
        registerOwner();
        initializeGUI();
    }

    private static void registerOwner() {
        // Solicitar la creación del dueño de la cuenta al inicio.
        JOptionPane.showMessageDialog(null, "Bienvenido a Twitter App, por favor registre al dueño de la cuenta.");
        addUser(true);
    }

    private static void initializeGUI() {
        JFrame frame = new JFrame("Twitter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        addButton("Registrar nuevo usuario", panel, e -> addUser(false));
        addButton("Cargar usuario en memoria", panel, e -> loadUser());
        addButton("Publicar tweet", panel, e -> publishTweet());
        addButton("Seguir a un usuario", panel, e -> followUser());
        addButton("Ver Timeline", panel, e -> viewTimeline());
        addButton("Enviar mensaje directo", panel, e -> sendDirectMessage());
        addButton("Ordenar usuarios por email", panel, e -> sortUsersByEmail());

        frame.add(panel);
        frame.setVisible(true);
    }
    private static void addButton(String text, JPanel panel, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setBackground(new Color(173, 216, 230)); // Light blue color
        panel.add(button);
    }

    private static void addUser(boolean isOwner) {
        String alias = JOptionPane.showInputDialog(null, "Introduzca el alias del usuario:");
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario:");
        try {
            userManager.addUser(alias, email);
            if (isOwner) {
                currentUser = userManager.findUserByEmail(email); // Asegurarse de que el dueño es el usuario actual.
            }
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
        if (tweetText == null || tweetText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tweet no puede estar vacío.");
            return;
        }
        Tweet tweet = new Tweet(tweetText);
        currentUser.tweet(tweet);
        JOptionPane.showMessageDialog(null, "Tweet publicado.");
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

    private static void sortUsersByEmail() {
        userManager.sortUsersByEmail();
        JOptionPane.showMessageDialog(null, "Usuarios ordenados por email.");
    }
}


