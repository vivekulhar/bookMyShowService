package dev.vivek.bookmyshow.repositories;

import dev.vivek.bookmyshow.models.SeatInAShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatInShowRepository extends JpaRepository<SeatInAShow,Long> {
    @Override
    List<SeatInAShow> findAllById(Iterable<Long> longs);
    @Override
    SeatInAShow save(SeatInAShow entity);
}
