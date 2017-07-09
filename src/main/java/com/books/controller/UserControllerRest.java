package com.books.controller;

import com.books.DTO.DTOUtilMaper;
import com.books.DTO.UserDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.books.entity.User;
import com.books.service.UserService;


import javax.enterprise.inject.Produces;
import java.security.Principal;
import java.util.List;

@Transactional
@RestController
public class UserControllerRest {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public List<UserDTO> saveUser(@RequestBody User user) throws Exception {
        userService.save(user);
        return DTOUtilMaper.userToDTOs(userService.findAll());
    }

    @GetMapping("/user")
    @Produces
//    @Produces({MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_XML })
    public List<UserDTO> loadUsers(){

//        List<User> users = userService.findAll();
//        for(User user: users) {
//            Hibernate.initialize(user.getOrders());
//            Hibernate.initialize(user.getBooks());
//        }
        return DTOUtilMaper.userToDTOs(userService.findAll());
    }

    @DeleteMapping("/user")
    public List<UserDTO> deleteUser(@RequestBody String idUser) {

        userService.delete(Integer.valueOf(idUser));
        return DTOUtilMaper.userToDTOs(userService.findAll());
    }

    @PutMapping("/user")
    public List<UserDTO> updateUser(@RequestBody String info, Model model) {
        userService.update(info);
        return DTOUtilMaper.userToDTOs(userService.findAll());
    }

    @GetMapping("/like")
    public @ResponseBody int like(@RequestBody int id, Principal principal) {
        System.out.println("like");
        userService.like(principal, id);
        return 200;
    }

//    @GetMapping("/user")
//    public List<User> like(@RequestBody String idUser, Principal principal) {
//        userService.like(principal, Integer.parseInt(idUser));
//        return userService.findAll();
//    }
}