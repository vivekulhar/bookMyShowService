package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatTypeInShow extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType; // ManyToOne
    @ManyToOne
    private MovieShow movieShow; // ManyToOne
    private int price;
}
