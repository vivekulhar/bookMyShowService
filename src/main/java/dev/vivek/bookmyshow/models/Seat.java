package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String number;
    private Long rowNum;
    private Long colNum;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium; // ManyToOne

    @OneToMany(mappedBy = "seat")
    private List<SeatInAShow> seatInAShows; // OneToMany
}
