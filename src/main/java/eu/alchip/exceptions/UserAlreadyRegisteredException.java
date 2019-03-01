package eu.alchip.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String msg){
        super(msg);
    }
}
