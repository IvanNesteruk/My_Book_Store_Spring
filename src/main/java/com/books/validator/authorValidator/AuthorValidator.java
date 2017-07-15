package com.books.validator.authorValidator;

import com.books.dao.AuthorDao;
import com.books.entity.Author;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorValidator implements Validator {
    @Autowired
    AuthorDao authorDao;

    @Override
    public void validate(Object o) throws Exception {
        Author author = (Author) o;

        if (author.getName().isEmpty()) {
            throw new AuthorException(AuthorValidationMessages.EMPTY_AUTHORNAME_FIELD);
        } else if (authorDao.findByName(author.getName()) != null) {
            throw new AuthorException(AuthorValidationMessages.AUTHORNAME_ALREADY_EXISTS);
        } else if (author.getSurname().isEmpty()){
            throw  new AuthorException(AuthorValidationMessages.EMPTY_AUTHORSURNAME_FIELD);
        }
    }
}
