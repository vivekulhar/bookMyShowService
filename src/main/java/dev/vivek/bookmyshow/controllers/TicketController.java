package dev.vivek.bookmyshow.controllers;

import dev.vivek.bookmyshow.dtos.BookTicketRequestDTO;
import dev.vivek.bookmyshow.dtos.BookTicketResponseDTO;
import dev.vivek.bookmyshow.dtos.ResponseStatus;
import dev.vivek.bookmyshow.models.Ticket;
import dev.vivek.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    // generate a ticket => select the seats
    // 1. retrieve
    // 2. check if available
    // 3.1 no => exception
    // 3.2 yes
    // lock the seats
    // generate a dummy ticket
    // redirect to payment gateway
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){
        BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();
        try{
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getSeatInAShowIds(),bookTicketRequestDTO.getUserId());
            bookTicketResponseDTO.setIdOfTheDummyTicket(ticket.getId());
            bookTicketResponseDTO.setStatus(ResponseStatus.SUCCESS);
            bookTicketResponseDTO.setMessage("Dummy ticket generated successfully. Go to payment gateway to finish booking the ticket.");

        }catch(Exception e){
            bookTicketResponseDTO.setStatus(ResponseStatus.FAILURE);
            bookTicketResponseDTO.setMessage("Something wrong happened. Couldn't book the ticket.");
            // log the error and send log id to the user
        }

        return bookTicketResponseDTO;
    }


}
