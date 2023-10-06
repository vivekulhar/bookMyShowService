package dev.vivek.bookmyshow.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User not found");
    }
}
