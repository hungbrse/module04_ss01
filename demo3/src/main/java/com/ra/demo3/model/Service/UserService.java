package com.ra.demo3.model.Service;

import com.ra.demo3.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
     User findById(long id);
     void save(User user);
     void delete(long id);
}
