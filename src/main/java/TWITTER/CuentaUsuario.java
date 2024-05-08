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
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public void follow(CuentaUsuario user) {
        if (!following.contains(user)) {
            following.add(user);
            user.addFollower(this);
        }
    }

    public void addFollower(CuentaUsuario user) {
        followers.add(user);
    }

    public void tweet(Tweet tweet) {
        tweets.add(tweet);
        for (CuentaUsuario follower : followers) {
            follower.addToTimeline(tweet);
        }
    }

    public void addToTimeline(Tweet tweet) {
        timeline.add(tweet);
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        CuentaUsuario user1 = new CuentaUsuario("user1", "areyemor@myuax.com");

    }

}