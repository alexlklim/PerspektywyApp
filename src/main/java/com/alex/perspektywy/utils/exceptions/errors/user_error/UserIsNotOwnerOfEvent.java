package com.alex.perspektywy.utils.exceptions.errors.user_error;

public class UserIsNotOwnerOfEvent extends RuntimeException{

    public UserIsNotOwnerOfEvent(final String message) {
        super(message);
    }
}
