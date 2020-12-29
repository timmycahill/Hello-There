package com.ex.persistence;

import com.ex.Models.Friend;
import com.ex.Models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is used as the DAO for the friend information
 */
@Repository()
@Transactional
public class FriendRepo {

    private SessionFactory sessionFactory;

    /**
     * this method setting up our repositories session factory
     * @param sessionFactory
     */
    @Autowired
    public FriendRepo(SessionFactory sessionFactory) {
        System.out.println("Creating Friend Repo");
        this.sessionFactory = sessionFactory;
    }

    /**
     * This method is adding a friend record to the database
     * @param user The paramters are User objects that represent users who are establishing a friendship
     * @param friended
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void addFriend(User user, User friended) {


        Session s = sessionFactory.getCurrentSession();
        Friend friendCreation = new Friend();
        friendCreation.setUser(user);
        friendCreation.setFriend(friended);
        s.save(friendCreation);
    }

    /**
     * This method is searching the data for all friends of a single user
     * @param userID The user of whom we are getting friends from
     * @return returns a list of users who are associated as friends with User in question
     */

    //retrieves the whole record big mess
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public List getAllF(String userID){
        Session s = sessionFactory.getCurrentSession();
        User desiredUser = new User();
        desiredUser.setId(Integer.parseInt(userID));

        Query hql = s.createQuery("From Friend WHERE user =:theUser ");
        hql.setParameter("theUser", desiredUser);
        return hql.list();
    }

}
