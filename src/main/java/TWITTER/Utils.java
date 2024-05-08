package TWITTER;


public class Utils {
    public static boolean isValidAlias(String alias) {
        return alias.matches("[a-zA-Z0-9]+");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
}
