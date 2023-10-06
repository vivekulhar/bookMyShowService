package dev.vivek.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{
    private Date bookingTime;
    private Date startTime;
    private Date endTime;
    private int maxTicket;
    private int lockingTimeout;
    @ManyToOne
    private Movie movie; // ManyToOne
    @ManyToOne
    private Auditorium auditorium; // ManyToOne
    @OneToMany(mappedBy = "movieShow")
    private List<SeatInAShow> seatInAShows; // OneToMany
    @OneToMany(mappedBy = "movieShow")
    private List<SeatTypeInShow> seatTypeInAShows; // OneToMany
}
