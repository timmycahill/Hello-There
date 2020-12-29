package com.ex.persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class MessageRepo {
    private SessionFactory sessionFactory;
    @Autowired
    public MessageRepo(SessionFactory sessionFactory) {
        System.out.println("Creating Message Repo");
        this.sessionFactory = sessionFactory;
    }
}
