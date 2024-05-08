package TWITTER;
public class Tweet {
    private String text;
    private CuentaUsuario user; // The user who created the tweet.

    public Tweet(String text, CuentaUsuario user) {
        this.text = text;
        this.user = user; // Ensure the user is set here.
    }

    public String getText() {
        return text;
    }

    public CuentaUsuario getUser() {
        return user;
    }
}
