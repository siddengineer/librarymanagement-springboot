// package com.example.library_db.repository;

// import com.example.library_db.entity.Member;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface MemberRepository extends JpaRepository<Member, Long> {
// }



package com.example.library_db.repository;

import com.example.library_db.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email); // ✅ ADD THIS
}