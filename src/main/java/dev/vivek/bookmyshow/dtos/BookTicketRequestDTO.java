package dev.vivek.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Long> seatInAShowIds;
    private Long userId;
}
