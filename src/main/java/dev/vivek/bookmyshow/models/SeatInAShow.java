package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SeatInAShow extends BaseModel{
    @ManyToOne
    private Seat seat; // ManyToOne
    @ManyToOne
    private MovieShow movieShow; // ManyToOne

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
    @ManyToOne
    private Ticket ticket; // ManyToOne
}
