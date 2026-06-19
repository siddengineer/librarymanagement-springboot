package com.example.library.issue;

import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import com.example.library.member.Member;
import com.example.library.member.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookIssueController {

    private static final BigDecimal FINE_PER_DAY = BigDecimal.valueOf(5);

    private final BookIssueRepository bookIssueRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BookIssueController(BookIssueRepository bookIssueRepository,
                                BookRepository bookRepository,
                                MemberRepository memberRepository) {
        this.bookIssueRepository = bookIssueRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestBody Map<String, Long> req) {
        Long bookId = req.get("bookId");
        Long memberId = req.get("memberId");

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) return ResponseEntity.badRequest().body("Book not found");

        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return ResponseEntity.badRequest().body("Member not found");

        if (book.getAvailableCopies() <= 0) {
            return ResponseEntity.badRequest().body("No copies available");
        }

        BookIssue issue = new BookIssue();
        issue.setBook(book);
        issue.setMember(member);
        issue.setIssueDate(LocalDate.now());
        issue.setDueDate(LocalDate.now().plusDays(7));

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        bookIssueRepository.save(issue);

        return ResponseEntity.ok("Book issued successfully");
    }

    @PostMapping("/return/{issueId}")
    public ResponseEntity<?> returnBook(@PathVariable Long issueId) {
        BookIssue issue = bookIssueRepository.findById(issueId).orElse(null);
        if (issue == null) return ResponseEntity.badRequest().body("Issue record not found");
        if (issue.getReturnDate() != null) return ResponseEntity.badRequest().body("Book already returned");

        LocalDate today = LocalDate.now();
        issue.setReturnDate(today);

        if (today.isAfter(issue.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(issue.getDueDate(), today);
            issue.setFineAmount(FINE_PER_DAY.multiply(BigDecimal.valueOf(daysLate)));
        }

        Book book = issue.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        bookIssueRepository.save(issue);

        return ResponseEntity.ok(issue);
    }

    @GetMapping("/all-issues")
    public List<BookIssue> getAllIssues() {
        return bookIssueRepository.findAll();
    }

    @GetMapping("/my-books/{memberId}")
    public List<BookIssue> getMyBooks(@PathVariable Long memberId) {
        return bookIssueRepository.findByMember_Id(memberId);
    }
}
