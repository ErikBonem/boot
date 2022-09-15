package com.spring.boot.sevice;

import com.spring.boot.dao.UserDao;
import com.spring.boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserService {
    private final UserDao userDaoImpl;

    @Autowired
    public UserService(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public List<User> index() {
        return userDaoImpl.index();
    }

    public User show(Long id){
        return userDaoImpl.show(id);
    }

    @Transactional
    public void save(User user){ userDaoImpl.save(user); }

    @Transactional
    public void update (User user){
        userDaoImpl.update(user);
    }

    @Transactional
    public void delete(Long id){
        userDaoImpl.delete(id);
    }
}
