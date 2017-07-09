package com.books.service.impl;

import java.security.Principal;
import java.util.List;

import com.books.dao.BookDao;
import com.books.dao.OrderDao;
import com.books.entity.Book;
import com.books.entity.Orders;
import com.books.entity.Role;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    @Qualifier("userValidator")
    Validator validator;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user) throws Exception {
        user.setName(user.getName().toUpperCase());
        validator.validate(user);
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {

        return userDao.findAll();

    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        User user = userDao.findUserWithOrders(id);
        for(Orders order: user.getOrders()){
            order.setUser(null);
            orderDao.saveAndFlush(order);
        }

        userDao.delete(id);

    }

    public void update(String info) {

        User user = userDao.findOne(Integer.parseInt(info.split("_")[1]));
        user.setName(info.split("_")[0]);
        userDao.save(user);
    }

    @Override
    public User findUserWithOrders(int id) {
        return userDao.findUserWithOrders(id);
    }

    @Override
    public User findUserWithBooks(int id) {
        return userDao.findUserWithBooks(id);
    }


    @Override
    public User findByUuid(String uuid) {
        return userDao.findByUuid(uuid);
    }

    @Override
    public void like(Principal principal, int id) {
        User user = userDao.findUserWithBooks(Integer.parseInt(principal.getName()));
        Book book = bookDao.findOne(id);
        user.getBooks().add(book);
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAllWithOrders() {
        return userDao.findAllWithOrders();
    }

    //UserDetailsService

    @Override
    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException {
        return userDao.findByName(value);
    }

}










