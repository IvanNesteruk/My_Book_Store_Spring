package com.books.validator.genreValidator;

import com.books.dao.GenreDao;
import com.books.entity.Genre;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 30.05.2017.
 */

@Component
public class GenreValidator implements Validator {

    @Autowired
    GenreDao genreDao;

    @Override
    public void validate(Object o) throws Exception {
        Genre genre = (Genre) o;

        if(genre.getGenreOfBook().isEmpty()){
            throw new GenreException(GenreValidationMessages.EMPTY_GENRENAME_FIELD);
        } else if (genreDao.findByGenreOfBook(genre.getGenreOfBook()) != null) {
            throw new GenreException(GenreValidationMessages.GENRENAME_ALREADY_EXISTS);
        }
    }
}
