package com.books.dao;

import com.books.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{

//	void addUserToOrder (User user, Orders orders);

}
