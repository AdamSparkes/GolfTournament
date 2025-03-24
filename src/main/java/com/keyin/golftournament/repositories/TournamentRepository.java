package com.keyin.golftournament.repositories;

import com.keyin.golftournament.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Tournament entity.
 */
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    // Find by exact start date
    List<Tournament> findByStartDate(LocalDate startDate);

    // Find tournaments that start after a certain date
    List<Tournament> findByStartDateAfter(LocalDate date);

    // Find tournaments by location
    List<Tournament> findByLocation(String location);

    // If you need partial matches, use 'Containing', 'Like', etc.
    // e.g., List<Tournament> findByLocationContaining(String partialLocation);
}