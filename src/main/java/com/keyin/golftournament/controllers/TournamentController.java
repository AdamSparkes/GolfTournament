package com.keyin.golftournament.controllers;

import com.keyin.golftournament.dto.TournamentDTO;
import com.keyin.golftournament.mappers.TournamentMapper;
import com.keyin.golftournament.models.Tournament;
import com.keyin.golftournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<TournamentDTO> getAllTournaments() {

        return tournamentService.getAllTournaments().stream()
                .map(TournamentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TournamentDTO getTournament(@PathVariable Long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        return TournamentMapper.toDTO(tournament);
    }

    @PostMapping
    public TournamentDTO createTournament(@RequestBody TournamentDTO tournamentDTO) {
        Tournament tournamentEntity = TournamentMapper.toEntity(tournamentDTO);
        Tournament savedTournament = tournamentService.createTournament(tournamentEntity);
        return TournamentMapper.toDTO(savedTournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }

}
