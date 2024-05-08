package TWITTER;

import java.time.LocalDate;

public class Tweet {
    private LocalDate time;
    private String message;
    private CuentaUsuario sender;
    private boolean text;
    private CuentaUsuario user;

    public Tweet(String message, CuentaUsuario sender) {
        this.time = LocalDate.now(); // Asumimos que la fecha del tweet es la actual.
        this.message = message;
        this.sender = sender;
    }

    public LocalDate getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public CuentaUsuario getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "time=" + time +
                ", message='" + message + '\'' +
                ", sender=" + (sender != null ? sender.getAlias() : "Unknown") +
                '}';
    }

    public boolean getText() {
           return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public CuentaUsuario getUser() {
        return user;
    }

    public void setUser(CuentaUsuario user) {
        this.user = user;
    }
}
