package eu.alchip.controllers;

import eu.alchip.exceptions.NoUserFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(NoUserFoundException.class)
    public String noUserFoundException() {
        return "error";
    }
}
