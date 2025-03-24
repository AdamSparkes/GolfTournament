package com.keyin.golftournament.mappers;

import com.keyin.golftournament.dto.MemberDTO;
import com.keyin.golftournament.models.Member;
import com.keyin.golftournament.models.Tournament;

import java.util.stream.Collectors;

public class MemberMapper {

    public static MemberDTO toDTO(Member member) {
        if (member == null) {
            return null;
        }
        MemberDTO dto = new MemberDTO();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setAddress(member.getAddress());
        dto.setEmail(member.getEmail());
        dto.setPhoneNumber(member.getPhoneNumber());
        dto.setStartDate(member.getStartDate());
        dto.setDuration(member.getDuration());
        dto.setMembershipType(member.getMembershipType());

        // If you want to show the tournament IDs
        dto.setTournamentIds(
                member.getTournaments().stream()
                        .map(Tournament::getId)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    public static Member toEntity(MemberDTO dto) {
        if (dto == null) {
            return null;
        }
        Member member = new Member();
        // ID is typically auto-generated, but if you need it for updates:
        // member.setId(dto.getId());
        member.setName(dto.getName());
        member.setAddress(dto.getAddress());
        member.setEmail(dto.getEmail());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setStartDate(dto.getStartDate());
        member.setDuration(dto.getDuration());
        member.setMembershipType(dto.getMembershipType());
        // We won't set Tournaments here to avoid cyclical relationships,
        // or you can handle it in the Service if needed.
        return member;
    }
}
