package com.keyin.golftournament.mappers;

import com.keyin.golftournament.dto.TournamentDTO;
import com.keyin.golftournament.models.Tournament;
import com.keyin.golftournament.models.Member;

import java.util.stream.Collectors;

public class TournamentMapper {

    public static TournamentDTO toDTO(Tournament tournament) {
        if (tournament == null) {
            return null;
        }
        TournamentDTO dto = new TournamentDTO();
        dto.setId(tournament.getId());
        dto.setStartDate(tournament.getStartDate());
        dto.setEndDate(tournament.getEndDate());
        dto.setLocation(tournament.getLocation());
        dto.setEntryFee(tournament.getEntryFee());
        dto.setCashPrize(tournament.getCashPrize());

        // If you want to show the member IDs
        dto.setMemberIds(
                tournament.getMembers().stream()
                        .map(Member::getId)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    public static Tournament toEntity(TournamentDTO dto) {
        if (dto == null) {
            return null;
        }
        Tournament tournament = new Tournament();
        // tournament.setId(dto.getId()); // Usually the DB auto-generates
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());
        tournament.setLocation(dto.getLocation());
        tournament.setEntryFee(dto.getEntryFee());
        tournament.setCashPrize(dto.getCashPrize());
        // We won't set Members here to avoid cyclical references.
        return tournament;
    }
}
