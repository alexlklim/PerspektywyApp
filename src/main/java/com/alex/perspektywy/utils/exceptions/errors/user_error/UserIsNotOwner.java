package com.alex.perspektywy.utils.exceptions.errors.user_error;

public class UserIsNotOwner extends RuntimeException{

    public UserIsNotOwner(final String message) {
        super(message);
    }
}
