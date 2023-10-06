package dev.vivek.bookmyshow.models;

import dev.vivek.bookmyshow.models.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String userName;
    private String password;
    private String phoneNo;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Role> roles; // ManyToMany
    @OneToMany(mappedBy = "bookedBy") // mappedBy is used to tell the other side of the relationship that this is the owner of the relationship
    private List<Ticket> tickets; // OneToMany
}
