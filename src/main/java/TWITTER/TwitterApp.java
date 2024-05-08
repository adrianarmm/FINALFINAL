package TWITTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwitterApp {
    private static UserManager userManager;
    private static CuentaUsuario currentUser;

    public static void main(String[] args) {


        JFrame frame = new JFrame("Twitter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        userManager = new UserManager();
        userManager.addUser("user1", "areyemor@myuax.com");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

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
        sortUsersByEmailButton.addActionListener(e -> sortUsersByEmail());
        panel.add(sortUsersByEmailButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void loadUser() {
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario a cargar:");
        CuentaUsuario user = userManager.findUserByEmail(email);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese email.");
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
        CuentaUsuario userToFollow = userManager.findUserByEmail(email);

        if (userToFollow == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        } else {
            currentUser.follow(userToFollow);
            JOptionPane.showMessageDialog(null, "Ahora sigues a: " + userToFollow.getAlias());
        }
    }

    private static void viewTimeline() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario cargado.");
            return;
        }
        StringBuilder timeline = new StringBuilder();
        for (Tweet tweet : currentUser.getTimeline()) {
            timeline.append(tweet.getText()).append(" - @").append(tweet.getUser().getAlias()).append("\n");
        }
        JOptionPane.showMessageDialog(null, timeline.toString(), "Timeline de " + currentUser.getAlias(), JOptionPane.INFORMATION_MESSAGE);
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
