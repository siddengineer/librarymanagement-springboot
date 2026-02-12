package com.example.library_db.service.impl;

import com.example.library_db.entity.Member;
import com.example.library_db.exception.MemberNotFoundException;
import com.example.library_db.repository.MemberRepository;
import com.example.library_db.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member registerMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));
    }

    @Override
    public Member updateMember(Long id, Member updatedMember) {

        Member member = getMemberById(id);

        member.setName(updatedMember.getName());
        member.setEmail(updatedMember.getEmail());
        member.setPhone(updatedMember.getPhone());
        member.setMembershipType(updatedMember.getMembershipType());

        return memberRepository.save(member);
    }

    @Override
    public void deactivateMember(Long id) {

        Member member = getMemberById(id);
        member.setActive(false);
        memberRepository.save(member);
    }
}
