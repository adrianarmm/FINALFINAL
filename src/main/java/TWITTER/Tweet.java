package TWITTER;
public class Tweet {
    private String text;
    private CuentaUsuario user; // The user who created the tweet.
    private String message;

    public Tweet(String text) {
        this.text = text;
        this.user = user; // Ensure the user is set here.
    }

    public String getText() {
        return text;
    }

    public CuentaUsuario getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
