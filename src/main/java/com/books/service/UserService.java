package com.books.service;

import java.security.Principal;
import java.util.List;

import com.books.entity.User;

public interface UserService {
    void save(User user) throws Exception;
    List<User> findAll();
    User findOne(int id);
    void delete(int id);
    void update(String info);

    User findUserWithOrders(int id);

    User findUserWithBooks(int id);

    User findByUuid(String uuid);

    void like(Principal principal, int id);


    void update(User user);
    List<User> findAllWithOrders();
}
