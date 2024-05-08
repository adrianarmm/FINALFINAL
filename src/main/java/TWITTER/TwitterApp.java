package TWITTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwitterApp {
    private static UserManager userManager;
    private static CuentaUsuario currentUser;

    public static void main(String[] args) {
        userManager = new UserManager();
        userManager.loadUsersFromFile("users.txt");

        JFrame frame = new JFrame("Twitter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opción");
        menuBar.add(menu);

        JMenuItem loadUserItem = new JMenuItem("Cargar usuario en memoria");
        loadUserItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUser();
            }
        });
        menu.add(loadUserItem);

        JMenuItem publishTweetItem = new JMenuItem("Publicar tweet");
        publishTweetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publishTweet();
            }
        });
        menu.add(publishTweetItem);

        JMenuItem sortUsersByEmailItem = new JMenuItem("Ordenar usuarios por email");
        sortUsersByEmailItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortUsersByEmail();
            }
        });
        menu.add(sortUsersByEmailItem);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private static void loadUser() {
        String email = JOptionPane.showInputDialog(null, "Introduzca el email del usuario a cargar:");

        CuentaUsuario user = userManager.findUserByEmail(email);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese email.");
        } else {
            currentUser = user;
            JOptionPane.showMessageDialog(null, "Usuario cargado: " + user.getName());
        }
    }

    private static void publishTweet() {
        String tweetText = JOptionPane.showInputDialog(null, "Introduzca el tweet a publicar:");

        if (tweetText.length() > 140) {
            JOptionPane.showMessageDialog(null, "El tweet no puede superar los 140 caracteres.");
            return;
        }

        Tweet tweet = new Tweet(tweetText);
        currentUser.publishTweet(tweet);

        JOptionPane.showMessageDialog(null, "Tweet publicado: " + tweet.getText());
    }

    private static void sortUsersByEmail() {
        userManager.sortUsersByEmail();
        JOptionPane.showMessageDialog(null, "Usuarios ordenados por email.");
    }
}