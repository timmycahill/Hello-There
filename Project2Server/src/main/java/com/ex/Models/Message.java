package com.ex.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "message_id", updatable = false, columnDefinition = "serial primary key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "User", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User fromUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="User", referencedColumnName = "user_id")
    private User toUser;

    @Column(name="message_content", nullable = false, updatable = true, columnDefinition = "")
    private String content;

    @Column(name="message_date", nullable = false, updatable = true, columnDefinition = "")
    private Date date;

    @Column(name="message_time", nullable = false, updatable = true, columnDefinition = "")
    private Time time;

    public Message(int id, User fromUser, User toUser, String content, Date date, Time time) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
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
        return "Message{" +
                "id=" + id +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
