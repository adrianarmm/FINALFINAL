package TWITTER;

public class DirectMessage extends Tweet {
    private CuentaUsuario receiver;

    // Corrección del constructor para incluir sender en la llamada al constructor de la superclase.
    public DirectMessage(String message, CuentaUsuario sender, CuentaUsuario receiver) {
        super(message, sender);  // Se pasa el sender correctamente.
        this.receiver = receiver;
    }

    public CuentaUsuario getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "receiver='" + (receiver
                != null ? receiver.getAlias() : "Unknown receiver") + '\'' +
                ", message='" + getMessage() + '\'' +
                ", sender='" + (getSender() != null ? getSender().getAlias() : "Unknown sender") + '\'' +
                '}';
    }
}