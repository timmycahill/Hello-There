package com.ex.Models;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "friends")
public class Friend implements Serializable {
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name ="user1_id",referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user2_id", referencedColumnName = "user_id")
    private User friend;

    public Friend() {
    }

    public Friend(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "user=" + user +
                ", friend=" + friend +
                '}';
    }
}
