package eu.alchip.controllers;

import eu.alchip.exceptions.NoUserFoundException;
import eu.alchip.exceptions.UserAlreadyRegisteredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({NoUserFoundException.class, UserAlreadyRegisteredException.class})
    public String noUserFoundException() {
        return "error";
    }
}
