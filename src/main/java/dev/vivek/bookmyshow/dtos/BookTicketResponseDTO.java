package dev.vivek.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private Long idOfTheDummyTicket;
    private ResponseStatus status;
    private String message;
}
