package com.books.DTO;

import com.books.entity.Book;
import com.books.entity.User;

import java.util.ArrayList;
import java.util.List;


public class DTOUtilMaper {

    public static List<UserDTO> userToDTOs(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public static List<BookDTO> bookDTOS(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitleOfBook(book.getTitleOfBook());
            bookDTO.setPriceOfBook(book.getPriceOfBook());

            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

}
