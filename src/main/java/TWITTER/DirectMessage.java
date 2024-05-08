import TWITTER.CuentaUsuario;
import TWITTER.Tweet;
Package TWITTER;

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

    // Delegate method to get the message from the superclass.
    public String getMessage() {
        return super.getMessage();
    }

    public static void main(String[] args) {
        CuentaUsuario sender = new CuentaUsuario("sender", "areyemor@myuax.com");
        CuentaUsuario receiver = new CuentaUsuario("receiver", "ruben@myuax.com");
        DirectMessage dm = new DirectMessage("Hola", sender, receiver);
        System.out.println(dm.toString());
    }
}