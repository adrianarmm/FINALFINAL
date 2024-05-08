package TWITTER;

import java.time.LocalDate;

public abstract class Tweet {
    protected LocalDate time;
    protected String message;
    protected CuentaUsuario sender;

    public Tweet(LocalDate time, String message, CuentaUsuario sender) {
        this.time = time;
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
                ", sender=" + sender.getAlias() +
                '}';
    }
}