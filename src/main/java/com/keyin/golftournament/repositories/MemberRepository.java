package com.keyin.golftournament.repositories;

import com.keyin.golftournament.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByMembershipType(String membershipType);

    List<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findByStartDate(LocalDate startDate);

    List<Member> findByStartDateAfter(LocalDate date);


}
