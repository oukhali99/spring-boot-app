package com.oukhali99.project.config;

import com.oukhali99.project.exception.MyException;
import com.oukhali99.project.model.responsebody.MyMessageResponseBody;
import com.oukhali99.project.model.responsebody.MyResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class)
    protected ResponseEntity<MyResponseBody> handle(MyException myException, WebRequest webRequest) {
        log.error(myException.getMessage());
        myException.printStackTrace();
        return new ResponseEntity<>(
                new MyMessageResponseBody(myException.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
