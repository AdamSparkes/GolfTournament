package com.keyin.golftournament.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for the Tournament entity.
 * Matches TournamentMapper, storing only member IDs.
 */
public class TournamentDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private BigDecimal entryFee;
    private BigDecimal cashPrize;

    // We'll store only the member IDs to avoid cyclical JSON
    private List<Long> memberIds;

    public TournamentDTO() {
        // No-args constructor required for JSON deserialization
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(BigDecimal entryFee) {
        this.entryFee = entryFee;
    }

    public BigDecimal getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(BigDecimal cashPrize) {
        this.cashPrize = cashPrize;
    }

    public List<Long> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Long> memberIds) {
        this.memberIds = memberIds;
    }
}
