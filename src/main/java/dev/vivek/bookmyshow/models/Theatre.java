package dev.vivek.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @OneToMany(mappedBy = "theatre")
    private List<Auditorium> auditoriums; // OneToMany

    @ManyToOne
    private City city; // ManyToOne
}
