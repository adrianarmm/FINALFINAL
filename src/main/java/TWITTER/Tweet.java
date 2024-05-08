package TWITTER;


public class Tweet {
    private String text;
    private CuentaUsuario user;

    public Tweet(String text) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public CuentaUsuario getUser() {
        return user;
    }

    protected String getMessage() {
            return text;
    }
}