package com.ex.persistence;

import com.ex.Models.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is used as the DAO to access User information
 */
@Repository
@Transactional
public class UserRepo {

    /**
     * This method is setting up the sessionfactory for this class
     */
    private SessionFactory sessionFactory;
    @Autowired
    public UserRepo(SessionFactory sessionFactory) {
        System.out.println("Creating User Repo");
        this.sessionFactory = sessionFactory;
    }

    /**
     * This method is getting all User accounts in the database
     * @return returns a list of user objects
     */
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List getAll() {
        Session s = sessionFactory.getCurrentSession();
        Query hql = s.createQuery("From User");
        return hql.list();
    }

    /**
     * This method creates a new user in the database
     * @param email The email of the new user
     * @param userName The userName of the new user
     * @param displayName The displayName of the new user
     * @param password The password of the new user
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void signUp(String email, String userName, String displayName, String password) {


            Session s = sessionFactory.getCurrentSession();
            int pass = password.hashCode();
            User userCreation = new User();
            userCreation.setEmail(email);
            userCreation.setUsername(userName);
            userCreation.setDisplayName(displayName);
            userCreation.setPassword(pass);
            s.save(userCreation);
    }

    /**
     * This method is validating the existence of an user account
     * @param username the user's username
     * @param password the user's password
     * @return returns the user information if the account exists in the database or returns no an empty list
     * if the account doesnt exist
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<User> checkUser(String username, String password){

        Session session = sessionFactory.getCurrentSession();
        int pass = password.hashCode();
        Query hql = session.createQuery("FROM User WHERE username =:name AND password =:passz");
        hql.setParameter("name", username);
        hql.setParameter("passz" , pass);

        List<User> objList = hql.list();

        return objList;
    }


//    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
//    public void updateInfo(int id, String email, String username, String displayName, int password){
//        Session session = sessionFactory.getCurrentSession();
//        Query hql = session.createQuery("UPDATE User set email = :newEmail, username = :newUsername, displayName = :newDN, password = :newPassword Where id = :userId");
//        hql.setParameter("userId", id);
//        hql.setParameter("newEmail", email);
//        hql.setParameter("newUsername", username);
//        hql.setParameter("newDN", displayName);
//        hql.setParameter("newPassword", Integer.hashCode(password));
//        hql.executeUpdate();
//    }

}
