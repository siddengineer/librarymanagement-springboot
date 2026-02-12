package com.example.library_db.controller;

import com.example.library_db.entity.Member;
import com.example.library_db.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member registerMember(@RequestBody Member member) {
        return memberService.registerMember(member);
    }

    @GetMapping
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberService.getAllMembers(pageable);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
                               @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        memberService.deactivateMember(id);
    }
}
