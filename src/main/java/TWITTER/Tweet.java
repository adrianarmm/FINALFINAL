package TWITTER;

import java.time.LocalDate;

public abstract class Tweet {
    private LocalDate time;
    private CuentaUsuario sender;
    private String message;

    public Tweet(LocalDate time, String sender, CuentaUsuario message) {
        this.time = time;
        this.sender = sender;
        this.message = message;
    }

    public LocalDate getTime() {
        return time;
    }

    public CuentaUsuario getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

}