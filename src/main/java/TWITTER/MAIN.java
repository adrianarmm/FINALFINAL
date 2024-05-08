package TWITTER;

import java.io.IOException;
import java.util.Scanner;

public class MAIN {
    private static final Scanner scanner = new Scanner(System.in);
    private static UserManager userManager;

    public static void main(String[] args) {
        userManager = new UserManager();
        userManager.loadUsersFromFile("users.txt");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Cargar usuario en memoria");
            System.out.println("2. Publicar tweet");
            System.out.println("3. Ordenar usuarios por email");
            System.out.println("4. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    loadUser();
                    break;
                case 2:
                    publishTweet();
                    break;
                case 3:
                    sortUsersByEmail();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void loadUser() {
        System.out.print("Introduzca el email del usuario a cargar: ");
        String email = scanner.nextLine();

        CuentaUsuario user = userManager.findUserByEmail(email);

        if (user == null) {
            System.out.println("No se encontró ningún usuario con ese email.");
        } else {
            System.out.println("Usuario cargado: " + user.getName());
            userManager.setCurrentUser(user);
        }
    }

    private static void publishTweet() {
        System.out.print("Introduzca el tweet a publicar: ");
        String tweetText = scanner.nextLine();

        if (tweetText.length() > 140) {
            System.out.println("El tweet no puede superar los 140 caracteres.");
            return;
        }

        Tweet tweet = new Tweet(tweetText);
        userManager.getCurrentUser().publishTweet(tweet);

        System.out.println("Tweet publicado: " + tweet.getText());
    }

    private static void sortUsersByEmail() {
        userManager.sortUsersByEmail();
        System.out.println("Usuarios ordenados por email.");
    }
}