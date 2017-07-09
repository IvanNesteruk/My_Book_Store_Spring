package com.books.service.impl;

import com.books.dao.BookDao;
import com.books.dao.GenreDao;
import com.books.entity.Book;
import com.books.entity.Genre;
import com.books.service.BookService;
import com.books.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("rawtypes")
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    @Qualifier("bookValidator")
    Validator validator;

    public Book save(Book book, MultipartFile image) throws Exception {
        validator.validate(book);
        String path = System.getProperty("catalina.home") + "/resources/"
                + book.getTitleOfBook() + "/" + image.getOriginalFilename();

        book.setPathImage("resources/" + book.getTitleOfBook() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        return bookDao.save(book);
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return bookDao.findAll();
    }

    public Book findOne(int id) {
        return bookDao.findOne(id);
    }

    public void delete(int id) {
        bookDao.delete(id);
    }

    public Book update(Book book, MultipartFile image) {

        book.setTitleOfBook(book.getTitleOfBook());

        String path = "C:\\Users\\User\\Desktop\\apache-tomcat-8.0.43\\resources\\"
                + book.getTitleOfBook()
                + "\\" + image.getOriginalFilename();
        book.setPathImage("resources/" + book.getTitleOfBook() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            try {
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/"
                                + book.getTitleOfBook() + "/"));
            } catch (IOException e) {

            }

            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        System.out.println("Size of book: " + image.getSize());
        return bookDao.save(book);
    }

    public void addGenreToBook(Book book, Genre genre) {
        book.setGenre(genre);
        bookDao.save(book);
    }

    @Override
    public Page<Book> findAllPages(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    @Override
    public Book update(Book book) {

       return bookDao.save(book);
    }
}
