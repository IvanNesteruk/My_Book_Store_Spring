package com.books.service.impl;

import java.util.List;

import com.books.DTO.BookDTO;
import com.books.dao.BookDao;
import com.books.entity.Book;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.books.dao.GenreDao;
import com.books.entity.Genre;
import com.books.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    @Qualifier("genreValidator")
    Validator validator;

    public Genre save(Genre genre) throws Exception {
        validator.validate(genre);
        return genreDao.save(genre);
    }

    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    public Genre findOne(int id) {
        return genreDao.findOne(id);
    }

    public void delete(int id) {
        Genre genre = genreDao.findGenreWithBooks(id);
        for (Book b : genre.getBooks()) {
            b.setGenre(null);
            bookDao.saveAndFlush(b);
        }
        genreDao.delete(id);
    }

    public Genre update(Genre genre) {
        return genreDao.save(genre);
    }


}
