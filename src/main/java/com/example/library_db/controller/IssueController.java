package com.example.library_db.controller;

import com.example.library_db.entity.BookIssue;
import com.example.library_db.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public BookIssue issueBook(@RequestParam Long bookId,
                               @RequestParam Long memberId) {
        return issueService.issueBook(bookId, memberId);
    }

    @PutMapping("/{id}/return")
    public BookIssue returnBook(@PathVariable Long id) {
        return issueService.returnBook(id);
    }

    @GetMapping("/member/{memberId}")
    public List<BookIssue> getMemberIssues(@PathVariable Long memberId) {
        return issueService.getMemberIssues(memberId);
    }

    @GetMapping("/overdue")
    public List<BookIssue> getOverdueBooks() {
        return issueService.getOverdueBooks();
    }
}
