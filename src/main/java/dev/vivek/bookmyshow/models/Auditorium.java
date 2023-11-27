package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String number;
    final int maximumRows=10;
    final int maximumColumns=10;

    /*@OneToMany(mappedBy = "auditorium")
    private List<Seat> seats; // OneToMany*/


    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> supportedFeatures; // ElementCollection

    @ManyToOne
    private Theatre theatre; // ManyToOne

    @OneToMany(mappedBy = "auditorium")
    private List<MovieShow> shows; // OneToMany
}
