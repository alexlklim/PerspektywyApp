package com.alex.perspektywy.utils.exceptions.errors.user_error;

public class UserNotRegisterYet extends RuntimeException{

    public UserNotRegisterYet(final String message) {
        super(message);
    }
}
