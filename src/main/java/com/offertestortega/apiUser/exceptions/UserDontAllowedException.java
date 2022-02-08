package com.offertestortega.apiUser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserDontAllowedException extends RuntimeException {
    public UserDontAllowedException(String s) {
        super(s);
    }
}
