package com.family.authentication.service;

import com.family.authentication.request.RegisterUserRequest;
import com.family.user.dao.UserDao;
import com.family.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;


@Slf4j
@Service
public class AuthenticationService {

    Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    @Autowired
    UserDao userDao;

    public String getUserFromPhone(String phone){
       User user = userDao.findByPhone(phone);
       if(Objects.nonNull(user)){
           user.setLoginTimeStamp(new Date());
           userDao.save(user);
           return user.getUserId();
       }
       return "0";
    }

    public String registerUser(RegisterUserRequest registerUserRequest){
        User user = mapper.map(registerUserRequest,User.class);
        user.setLoginTimeStamp(new Date());
        user = userDao.save(user);
        return user==null?null:user.getUserId();
    }
}
