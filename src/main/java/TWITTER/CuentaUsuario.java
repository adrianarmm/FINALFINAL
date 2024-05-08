package TWITTER;

import java.util.ArrayList;
import java.util.List;

public class CuentaUsuario {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<CuentaUsuario> following;
    private List<CuentaUsuario> followers;
    private List<Tweet> timeline;

    public CuentaUsuario(String alias, String email) {
        if (!Utils.isValidAlias(alias) || !Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Nombre de usuario o email no válido");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public void follow(CuentaUsuario user) {
        if (user != null && !this.equals(user) && !following.contains(user)) {
            following.add(user);
            user.addFollower(this);
        }
    }

    private void addFollower(CuentaUsuario user) {
        if (!followers.contains(user)) {
            followers.add(user);
        }
    }

    public void tweet(Tweet tweet) {
        if (tweet != null) {
            tweets.add(tweet);
            for (CuentaUsuario follower : followers) {
                follower.addToTimeline(tweet);
            }
        }
    }

    private void addToTimeline(Tweet tweet) {
        if (tweet != null) {
            timeline.add(tweet);
        }
    }

    @Override
    public String toString() {
        return "CuentaUsuario{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getAlias() {
        return alias;
    }

    public static void main(String[] args) {
            CuentaUsuario user1 = new CuentaUsuario("johnDoe", "johndoe@example.com");
            CuentaUsuario user2 = new CuentaUsuario("janeDoe", "janedoe@example.com");
            CuentaUsuario user3 = new CuentaUsuario("bobDoe", "bobdoe@example.com");

            user1.follow(user2);
            user1.follow(user3);

            Tweet tweet1 = new Tweet("Hello, world!", user2);
            Tweet tweet2 = new Tweet("This is my second tweet!", user3);

            user2.tweet(tweet1);
            user3.tweet(tweet2);

            System.out.println("Timeline de " + user1.getAlias() + ":");
            for (Tweet tweet : user1.timeline) {
                System.out.println(tweet.getText() + " - @" + tweet.getUser().getAlias());
            }
        }
    }
