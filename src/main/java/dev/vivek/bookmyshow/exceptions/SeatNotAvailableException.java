package dev.vivek.bookmyshow.exceptions;

import dev.vivek.bookmyshow.models.Seat;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(){
        super("Seat not available");
    }
}
