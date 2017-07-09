package com.books.validator.userValidator;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by User on 29.05.2017.
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserException(UserValidationMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) != null) {
            throw new UserException(UserValidationMessages.USERNAME_ALREADY_EXISTS);
        } else if (user.getEmail().isEmpty()) {
            throw new UserException(UserValidationMessages.EMPTY_USEREMAIL_FIELD);
        } else if (user.getPassword().isEmpty()) {
            throw new UserException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
        }
    }
}










