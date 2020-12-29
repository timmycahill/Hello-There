package com.ex.persistence;

import com.ex.Models.Post;
import com.ex.Models.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * This class is used as the DAO to access post information
 */
@Repository
@Transactional
public class PostRepo {
    private SessionFactory sessionFactory;

    /**
     * This method is setting up the sessionfactory for the Post repository
     * @param sessionFactory
     */
    @Autowired
    public PostRepo(SessionFactory sessionFactory) {
        System.out.println("Creating Post Repo");
        this.sessionFactory = sessionFactory;
    }

    /**
     * This method is used to create a Post
     * @param author The user creating the post
     * @param content The content of the post
     * @param date The date when the post was created
     * @param time The time when the post was created
     * @param location The location where the post was created
     * @param isFlagged The representation of a the post being flagged as innapropriate, the default value is false
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void createPost(User author, String content, Date date, Time time, String location, boolean isFlagged) {

        Session s = sessionFactory.getCurrentSession();
        Post postCreation = new Post();
        postCreation.setAuthor(author);
        postCreation.setContent(content);
        postCreation.setDate(date);
        postCreation.setTime(time);
        postCreation.setLocation(location);
        postCreation.setFlagged(isFlagged);


        s.save(postCreation);
    }

    /**
     * This method gets all posts from the database
     * @return returns a list of a Posts Objects
     */
    @Transactional( readOnly = true, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public List getAllPosts(){
        Session s = sessionFactory.getCurrentSession();
        Query hql = s.createQuery("From Post order by date desc, time desc");
        return hql.list();
    }

    /**
     * This method gets all of the posts made by a single user
     * @param user The User we are trying to get Posts from
     * @return returns a list of Post Objects
     */
    @Transactional (readOnly = true, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE )
    public List<Post> getUserPosts(String username){
        Session session = sessionFactory.getCurrentSession();

        User obj = PostRepo.this.getUserForPosts(username).get(0);

        Query hql2 = session.createQuery("FROM Post WHERE author = :user order by date desc, time desc");
        hql2.setParameter("user", obj);
        return hql2.list();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<User> getUserForPosts(String username){

        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("FROM User WHERE username =:name");
        hql.setParameter("name", username);;
        return hql.list();
    }


    @Transactional (propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void updatePost(int id, String content){
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("UPDATE Post set content = :newContent, date = :newDate, time = :newTime Where id = :postId");
        hql.setParameter("newContent", content);
        hql.setParameter("newDate", Date.valueOf(LocalDate.now()));
        hql.setParameter("newTime", Time.valueOf(LocalTime.now()));
        hql.setParameter("postId", id);

        hql.executeUpdate();
    }

    @Transactional (propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void flag(int id){
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("UPDATE Post set isFlagged = :flag Where id = :postId");
        hql.setParameter("flag", true);
        hql.setParameter("postId", id);
        hql.executeUpdate();
    }

}
