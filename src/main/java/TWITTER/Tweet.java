package TWITTER;

import java.time.LocalDate;

public class Tweet {
    private LocalDate time;
    private String message;
    private CuentaUsuario sender;

    // Constructor modificado para incluir CuentaUsuario como el remitente del tweet.
    public Tweet(String message, CuentaUsuario sender) {
        this.time = LocalDate.now(); // Asumimos que el tweet se crea con la fecha actual.
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
                ", sender=" + (sender != null ? sender.getAlias() : "Unknown") + // Verifica si el remitente es nulo antes de acceder a su alias.
                '}';
    }

}
