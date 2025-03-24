package com.keyin.golftournament.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO for the Member entity.
 * Includes all fields that match MemberMapper plus a list of tournamentIds.
 */
public class MemberDTO {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate startDate;
    private int duration;
    private String membershipType;

    // We'll store only the IDs of Tournaments to avoid huge or cyclical JSON
    private List<Long> tournamentIds;

    public MemberDTO() {
        // No-args constructor required for JSON deserialization
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public List<Long> getTournamentIds() {
        return tournamentIds;
    }

    public void setTournamentIds(List<Long> tournamentIds) {
        this.tournamentIds = tournamentIds;
    }
}

