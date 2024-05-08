package TWITTER;

public class Retweet extends Tweet {
    private Tweet originalTweet;

    // Corrección del constructor para incluir sender en la llamada al constructor de la superclase.
    public Retweet(String message, CuentaUsuario sender, Tweet originalTweet) {
        super(message);  // Se pasa el sender correctamente.
        this.originalTweet = originalTweet;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet{" +
                "originalTweet='" + (originalTweet != null ? originalTweet.getMessage() : "No original message") + '\'' +
                ", message='" + getMessage() + '\'' +
                ", sender='" + (getSender() != null ? getSender().getAlias() : "Unknown sender") + '\'' +
                '}';
    }

    private CuentaUsuario getSender() {
        return super.getUser();
    }
}
