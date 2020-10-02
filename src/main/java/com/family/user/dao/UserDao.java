package com.family.user.dao;

import com.family.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,String> {

    User findByPhone(String phone);
}
