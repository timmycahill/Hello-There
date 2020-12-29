package com.ex.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "comment_id", updatable = false, columnDefinition = "serial primary key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name ="post_id",referencedColumnName = "post_id")
    private Post associatedPost;

    @ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(name = "author_id" , referencedColumnName = "user_id")
    private User author;


    @Column(name="comment_content", nullable = false, updatable = true, columnDefinition = "")
    private String content;

    @Column(name="comment_date", nullable = false, updatable = true, columnDefinition = "")
    private Date date;

    @Column(name="comment_time", nullable = false, updatable = true, columnDefinition = "")
    private Time time;

    public Comment(int id, Post associatedPost, User author, String content, Date date, Time time) {
        this.id = id;
        this.associatedPost = associatedPost;
        this.author = author;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public Comment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getAssociatedPost() {
        return associatedPost;
    }

    public void setAssociatedPost(Post associatedPost) {
        this.associatedPost = associatedPost;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", associatedPost=" + associatedPost +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
