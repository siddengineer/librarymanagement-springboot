package com.example.library_db.service.impl;

import com.example.library_db.entity.*;
import com.example.library_db.exception.*;
import com.example.library_db.repository.*;
import com.example.library_db.service.IssueService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookIssueRepository issueRepository;

    public IssueServiceImpl(BookRepository bookRepository,
                            MemberRepository memberRepository,
                            BookIssueRepository issueRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.issueRepository = issueRepository;
    }

    @Override
    @Transactional
    public BookIssue issueBook(Long bookId, Long memberId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));

        if (!member.isActive()) {
            throw new RuntimeException("Member is inactive");
        }

        if (book.getAvailableCopies() <= 0) {
            throw new BookNotAvailableException("Book not available");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        BookIssue issue = new BookIssue();
        issue.setBook(book);
        issue.setMember(member);
        issue.setIssueDate(LocalDate.now());
        issue.setDueDate(LocalDate.now().plusDays(14));

        return issueRepository.save(issue);
    }

    @Override
    @Transactional
    public BookIssue returnBook(Long issueId) {

        BookIssue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        issue.setReturnDate(LocalDate.now());

        if (issue.getReturnDate().isAfter(issue.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(
                    issue.getDueDate(),
                    issue.getReturnDate());

            issue.setFineAmount(BigDecimal.valueOf(daysLate * 5));
        }

        Book book = issue.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        return issue;
    }

    @Override
    public List<BookIssue> getMemberIssues(Long memberId) {
        return issueRepository.findByMemberId(memberId);
    }

    @Override
    public List<BookIssue> getOverdueBooks() {
        return issueRepository.findOverdueBooks();
    }
}
