package TWITTER;


import java.time.LocalDate;

public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(LocalDate time, String message, CuentaUsuario sender, Tweet originalTweet) {
        super(message);
        this.originalTweet = originalTweet;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet{" +
                "originalTweet=" + originalTweet.getMessage() +
                ", message='" + getMessage() + '\'' +
                ", sender=" + getSender().getAlias() +
                '}';
    }
}