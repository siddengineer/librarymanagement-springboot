package com.example.library_db.service;

import com.example.library_db.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Member registerMember(Member member);

    Page<Member> getAllMembers(Pageable pageable);

    Member getMemberById(Long id);

    Member updateMember(Long id, Member member);

    void deactivateMember(Long id);
}
