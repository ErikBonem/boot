package com.spring.boot.dao;

import com.spring.boot.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager em;
    public List<User> index() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
    public User show(Long id){
        return em.find(User.class,id);
    }
    @Transactional
    public void save(User user){
        em.persist(user);
    }
    @Transactional
    public void update (User user){
        em.merge(user);
    }
    @Transactional
    public void delete(Long id){
        em.remove(show(id));
    }
}
