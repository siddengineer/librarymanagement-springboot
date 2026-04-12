package com.example.library_db.repository;

import com.example.library_db.entity.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

    List<BookIssue> findByMember_Id(Long memberId);

    @Query("SELECT b FROM BookIssue b WHERE b.dueDate < CURRENT_DATE AND b.returnDate IS NULL")
    List<BookIssue> findOverdueBooks();
}
