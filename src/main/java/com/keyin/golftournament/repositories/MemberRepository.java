package com.keyin.golftournament.repositories;

import com.keyin.golftournament.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Member entity.
 * Extending JpaRepository provides methods like findAll(), findById(), save(), deleteById(), etc.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * Derived Query Methods:
     * Spring Data JPA will automatically implement these
     * based on the method name and parameters.
     */

    // Find members by exact match of name
    List<Member> findByName(String name);

    // Find members by membership type
    List<Member> findByMembershipType(String membershipType);

    // Find members by phone number
    List<Member> findByPhoneNumber(String phoneNumber);

    // Find members by the exact start date
    List<Member> findByStartDate(LocalDate startDate);

    // Find members whose start date is after a certain date
    List<Member> findByStartDateAfter(LocalDate date);

    // If you need a partial match (e.g., for name), you can use Containing, Like, etc.
    // e.g.: List<Member> findByNameContaining(String partialName);
}
