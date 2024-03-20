package com.alex.perspektywy.utils.exceptions.errors;

public class UserAlreadyCreateEventForThisBranch extends RuntimeException{

    public UserAlreadyCreateEventForThisBranch(final String message) {
        super(message);
    }

}
