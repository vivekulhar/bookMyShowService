package dev.vivek.bookmyshow.services;

import dev.vivek.bookmyshow.exceptions.SeatNotAvailableException;
import dev.vivek.bookmyshow.exceptions.UserNotFoundException;
import dev.vivek.bookmyshow.models.SeatInAShow;
import dev.vivek.bookmyshow.models.Ticket;
import dev.vivek.bookmyshow.models.User;
import dev.vivek.bookmyshow.models.enums.SeatStatus;
import dev.vivek.bookmyshow.repositories.SeatInShowRepository;
import dev.vivek.bookmyshow.repositories.TicketRepository;
import dev.vivek.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private SeatInShowRepository seatInAShowRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, SeatInShowRepository seatInAShowRepository){
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.seatInAShowRepository = seatInAShowRepository;
    }

    public Ticket bookTicket(List<Long> seatInAShowIds, Long userId) throws SeatNotAvailableException, UserNotFoundException {
        List<SeatInAShow> seats = seatInAShowRepository.findAllById(seatInAShowIds);
        for(SeatInAShow seat: seats){
            if(IsAvailable(seat) == false){
                throw new SeatNotAvailableException();
            }
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        User bookedBy = userOptional.get();

        List<SeatInAShow>  updatedSeats = new ArrayList<>();
        Date current = new Date();

        for(SeatInAShow seat: seats){
            seat.setSeatStatus(SeatStatus.BLOCKED);
            seat.setLockedAt(current);
            seat = seatInAShowRepository.save(seat);
            updatedSeats.add(seat);
        }
        Ticket ticket = new Ticket();
        ticket.setBookedBy(bookedBy);
        ticket.setBookingTime(current);
        ticket.setSelectedSeats(updatedSeats);
        ticket.setAmount(0);
        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
    public boolean IsAvailable(SeatInAShow seat){
        if(seat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
            return true;
        }else if(seat.getSeatStatus().equals(SeatStatus.BLOCKED)){
            //logic
            long lockedAt = seat.getLockedAt().getTime();
            long current = System.currentTimeMillis();

            long duration = current - lockedAt;
            long durationInSeconds = duration/1000;
            long durationInMinutes = durationInSeconds/60;

            if(durationInMinutes >=10){
                return true;
            }else{
                return false;
            }
        }
        return false;

    }

    /*@Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public List<ShowSeat> getAndLokcShowSeats(List<Seat> seats, Optional<Show> showOptional) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, showOptional.get());

        for (ShowSeat showSeat: showSeats) {
            if (!(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE) || (
                    showSeat.getStatus().equals(ShowSeatStatus.LOCKED)))) { // && new Date( - showSeat.getLockedAt())))) {
                throw new SeatNotAvailableException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat: showSeats) {
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }


        return showSeats;
    }*/
}
