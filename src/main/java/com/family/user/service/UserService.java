package com.family.user.service;

import com.family.user.dao.UserDao;
import com.family.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(String phone){

        User user = userDao.findByPhone(phone);

        return user!=null?user:new User();

    }
}
