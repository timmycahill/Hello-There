package com.ex.persistence;

import com.ex.Models.Like;
import com.ex.Models.Post;
import com.ex.Models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LikeRepo {

    private SessionFactory sessionFactory;

    /**
     * This method is setting up the sessionfactory for the Post repository
     * @param sessionFactory
     */
    @Autowired
    public LikeRepo(SessionFactory sessionFactory) {
        System.out.println("Creating Post Repo");
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @param post
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void likePost(Post post, User user) {


        Session s = sessionFactory.getCurrentSession();
        Like likeCreation = new Like();
        likeCreation.setPost(post);
        likeCreation.setUser(user);
        s.save(likeCreation);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public List<Like> getLikes(String postId){
        Session s = sessionFactory.getCurrentSession();
        Post desiredPost = new Post();
        desiredPost.setId(Integer.parseInt(postId));

        Query hql = s.createQuery("From Like Where post_id =:identifier");
        hql.setParameter("identifier", desiredPost);
        return hql.list();
    }

  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
  public void deleteLike(String postId, String userId){
    Session s = sessionFactory.getCurrentSession();
    Post post = new Post();
    post.setId(Integer.parseInt(postId));

    User user = new User();
    user.setId(Integer.parseInt(userId));

    Query hql = s.createQuery("Delete From Like Where post_id = :postID and user_id = :userID");
    hql.setParameter("postID", post);
    hql.setParameter("userID", user);
    hql.executeUpdate();


  }

}
