package com.family.user.service;

import com.family.user.dao.UserDao;
import com.family.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(String userId){

        User user = userDao.findOne(userId);

        return user!=null?user:new User();

    }
}
