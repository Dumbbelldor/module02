package com.epam.advice;

import com.epam.exception.GiftNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GiftNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GiftNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String giftNotFoundHandler(GiftNotFoundException e) {
        return e.getMessage();
    }
}
