package TWITTER;

import java.time.LocalDate;

public class DirectMessage extends Tweet {
    private CuentaUsuario receiver;

    public DirectMessage(LocalDate time, String message, CuentaUsuario sender, CuentaUsuario receiver) {
        super(message);
        this.receiver = receiver;
    }

    public CuentaUsuario getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "receiver=" + receiver.getAlias() +
                ", message='" + getMessage() + '\'' +
                ", sender=" + getSender().getAlias() +
                '}';
    }
}