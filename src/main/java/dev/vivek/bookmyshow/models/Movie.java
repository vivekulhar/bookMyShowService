package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie  extends BaseModel{
    private String name;
    private int duration;
    @OneToMany(mappedBy = "movie")
    private List<MovieShow> movieShows; // OneToMany

    @ManyToMany(mappedBy = "movies") // mappedBy is used to tell the other side of the relationship that this is the owner of the relationship
    private List<Actor> actors; // ManyToMany

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Features> requiredFeatures;

}
