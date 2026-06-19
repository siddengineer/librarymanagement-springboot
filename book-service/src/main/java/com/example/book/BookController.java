// package com.example.library_db.controller;

// import com.example.library_db.entity.Book;
// import com.example.library_db.service.BookService;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/books")
// public class BookController {

//     private final BookService bookService;

//     public BookController(BookService bookService) {
//         this.bookService = bookService;
//     }

//     @PostMapping
//     public Book addBook(@RequestBody Book book) {
//         return bookService.addBook(book);
//     }

//     @GetMapping
//     public Page<Book> getAllBooks(Pageable pageable) {
//         return bookService.getAllBooks(pageable);
//     }

//     @GetMapping("/{id}")
//     public Book getBook(@PathVariable Long id) {
//         return bookService.getBookById(id);
//     }

//     @PutMapping("/{id}")
//     public Book updateBook(@PathVariable Long id,
//                            @RequestBody Book book) {
//         return bookService.updateBook(id, book);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteBook(@PathVariable Long id) {
//         bookService.deleteBook(id);
//     }
// }





package com.example.issue.controller;

import com.example.book.Book;
import com.example.issue.BookIssue;
import com.example.member.Member;

import com.example.issue.repository.BookIssueRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookIssueRepository bookIssueRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BookController(BookIssueRepository bookIssueRepository,
                          BookRepository bookRepository,
                          MemberRepository memberRepository) {
        this.bookIssueRepository = bookIssueRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    // ✅ ADMIN: ISSUE BOOK
    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestBody Map<String, Long> req) {

        Long bookId = req.get("bookId");
        Long memberId = req.get("memberId");

        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        // ❗ CHECK AVAILABLE COPIES
        if (book.getAvailableCopies() <= 0) {
            return ResponseEntity.badRequest().body("No copies available");
        }

        BookIssue issue = new BookIssue();
        issue.setBook(book);
        issue.setMember(member);
        issue.setIssueDate(LocalDate.now());
        issue.setDueDate(LocalDate.now().plusDays(7));

        // 🔥 reduce available copies
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        bookIssueRepository.save(issue);

        return ResponseEntity.ok("Book issued successfully");
    }

    // ✅ ADMIN: SEE ALL ISSUES
    @GetMapping("/all-issues")
    public List<BookIssue> getAllIssues() {
        return bookIssueRepository.findAll();
    }

    // ✅ STUDENT: SEE OWN BOOKS
    @GetMapping("/my-books/{memberId}")
    public List<BookIssue> getMyBooks(@PathVariable Long memberId) {
        return bookIssueRepository.findByMember_Id(memberId);
    }
}