package com.books.service.impl;

import com.books.dao.BookDao;
import com.books.dao.OrderDao;
import com.books.dao.UserDao;
import com.books.entity.Book;
import com.books.entity.Orders;
import com.books.entity.User;
import com.books.service.OrderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    public Orders save(Orders orders) {
        return orderDao.save(orders);
    }

    public List<Orders> findAll() {
        return orderDao.findAll();
    }

    public Orders findOne(int id) {
        return orderDao.findOne(id);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    public Orders update(Orders orders) {
        return orderDao.save(orders);
    }

    @Override
    public void addIntoBasket(Principal principal, int id) {
        User user = userDao.findUserWithBooks(Integer.parseInt(principal.getName()));
        Book book = bookDao.findOne(id);
        user.getBooks().add(book);
        userDao.save(user);
    }

    @Override
    public void deleteFromBasket(int userId, int bookId) {

        User user = userDao.findUserWithBooks(userId);
        Book book = bookDao.booksWithUsers(bookId);
        user.getBooks().remove(book);
        userDao.save(user);
    }

    @Override
    public void buy(int userId) {
        Orders orders = new Orders(LocalDateTime.now());
        orderDao.saveAndFlush(orders);
        User user = userDao.findUserWithBooks(userId);
        orders.setUser(user);
        for (Book book : user.getBooks()) {
            orders.getBooks().add(book);

            orderDao.save(orders);
        }

        user.getBooks().clear();
        userDao.save(user);
    }

    public void save(int userId, List<Integer> booksIds) {
        Orders orders = new Orders(LocalDateTime.now());
        orderDao.saveAndFlush(orders);

        List<Book> books = new ArrayList<Book>();

        for (Integer id : booksIds) {
            books.add(bookDao.findOne(id));
        }

        orders.setBooks(new HashSet<Book>(books));
        User user = userDao.findOne(userId);
        orders.setUser(user);

        orderDao.save(orders);
    }

    @Override
    public void makeSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getTotalPrice() {

        int price = 0;

        List<Orders> orders = orderDao.findAll();
        for (Orders order : orders) {
            Hibernate.initialize(order.getBooks()
            );

            for (Book book : order.getBooks()) {
                price += book.getPriceOfBook() * book.getQuantity();
                order.setTotalPrice(price);
            }
        }
    }

}

