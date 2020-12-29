package com.ex.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "user_id", columnDefinition = "INT")
    private User author;

    @Column(name="post_content")
    private String content;

    @Column(name="post_date")
    private Date date;

    @Column(name="post_time")
    private Time time;

    @Column(name="post_location")
    private String location;

    @Column(name="is_flagged")
    private boolean isFlagged;




    public Post(int id, User author, String content, Date date, Time time, String location, boolean isFlagged) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.date = date;
        this.time = time;
        this.location = location;
        this.isFlagged = isFlagged;
    }

    public Post() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", isFlagged=" + isFlagged +
                '}';
    }
}
