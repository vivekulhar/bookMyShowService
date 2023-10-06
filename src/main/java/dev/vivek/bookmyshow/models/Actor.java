package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Actor  extends BaseModel{
    private String name;
    @ManyToMany(mappedBy = "actors") // mappedBy is used to tell the other side of the relationship that this is the owner of the relationship
    private List<Movie> movies; // ManyToMany

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
