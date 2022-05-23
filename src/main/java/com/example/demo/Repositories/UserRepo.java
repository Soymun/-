package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User findByUsername(String username){
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        User user = session.createQuery("FROM User u where u.username = :user", User.class).setParameter("user", username)
                .getResultList().stream().findFirst().orElse(null);
        session.getTransaction().commit();
        return user;
    }

    public void save(User user) {
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
