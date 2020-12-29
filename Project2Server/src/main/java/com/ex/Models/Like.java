package com.ex.Models;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "likes")
public class Like implements Serializable {

    @Id
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="post_id" ,referencedColumnName= "post_id")
    private Post post;

    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name ="user_id", referencedColumnName = "user_id")
    private User user;

    public Like(Post post_id, User user) {
        this.post = post_id;
        this.user = user;
    }

    public Like() {
    }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
    public String toString() {
        return "Like{" +
                "post_id=" + post+
                ", user=" + user +
                '}';
    }
}
