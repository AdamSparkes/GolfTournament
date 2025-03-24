package com.keyin.golftournament.controllers;

import com.keyin.golftournament.dto.MemberDTO;
import com.keyin.golftournament.mappers.MemberMapper;
import com.keyin.golftournament.models.Member;
import com.keyin.golftournament.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {

        return memberService.getAllMembers().stream()
                .map(MemberMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemberDTO getMember(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return MemberMapper.toDTO(member);
    }

    @PostMapping
    public MemberDTO createMember(@RequestBody MemberDTO memberDTO) {
        // Convert DTO -> Entity
        Member memberEntity = MemberMapper.toEntity(memberDTO);
        // Save via service
        Member savedMember = memberService.createMember(memberEntity);
        // Convert back to DTO
        return MemberMapper.toDTO(savedMember);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }



}
