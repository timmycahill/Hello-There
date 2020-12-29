package com.ex.persistence;

import com.ex.Models.Comment;
import com.ex.Models.Post;
import com.ex.Models.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
@Transactional

public class CommentRepo {
    private SessionFactory sessionFactory;

    @Autowired
    public CommentRepo(SessionFactory sessionFactory) {
        System.out.println("Creating Comment Repo");
        this.sessionFactory = sessionFactory;
    }

    //what i dont have
    @Transactional
    public void createComment(Post post,User user,String content, Date date, Time time){

        Session s = sessionFactory.getCurrentSession();
        Comment comment = new Comment();
        comment.setAssociatedPost(post);
        comment.setAuthor(user);
        comment.setContent(content);
        comment.setDate(date);
        comment.setTime(time);
        s.save(comment);

    }


    @Transactional
    public List getPostComments(String postID){
        Session s = sessionFactory.getCurrentSession();

        Post desiredPost = new Post();
        desiredPost.setId(Integer.valueOf(postID));
        Query hql = s.createQuery("From Comment WHERE associatedPost =:postData ");
        hql.setParameter("postData", desiredPost);
        return hql.list();
    }
}
