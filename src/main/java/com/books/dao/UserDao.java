package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.entity.User;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query("select u from User u left join fetch u.books where u.id=:id")
	User findUserWithBooks(@Param("id") int id);

	@Query("select u from User u where u.name=:name or u.email=:name")
	User findByName(@Param("name") String name);

	@Query("select u from User u left join fetch u.orders o left join fetch o.books where u.id=:id")
	User findUserWithOrders(@Param("id") int id);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);

	@Query("select distinct u from  User u left join fetch u.orders")
	List<User> findAllWithOrders();



}
