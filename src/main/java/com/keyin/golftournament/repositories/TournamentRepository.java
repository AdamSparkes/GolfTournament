package com.keyin.golftournament.repositories;

import com.keyin.golftournament.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {


    List<Tournament> findByStartDate(LocalDate startDate);


    List<Tournament> findByStartDateAfter(LocalDate date);


    List<Tournament> findByLocation(String location);

}