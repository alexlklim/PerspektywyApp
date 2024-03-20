package com.alex.perspektywy.utils.exceptions.errors.user_error;

public class UserFailedAuthentication extends RuntimeException{

    public UserFailedAuthentication(final String message) {
        super(message);
    }

}
