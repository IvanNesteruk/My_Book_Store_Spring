package com.books.validator.userLoginValidation;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.validator.Validator;
import com.books.validator.userValidator.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by User on 10.06.2017.
 */
@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) == null) {
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(),
                userDao.findByName(user.getName()).getPassword())) {
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        }
    }
}
