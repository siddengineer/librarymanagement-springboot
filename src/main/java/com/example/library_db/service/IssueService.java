package com.example.library_db.service;

import com.example.library_db.entity.BookIssue;

import java.util.List;

public interface IssueService {

    BookIssue issueBook(Long bookId, Long memberId);

    BookIssue returnBook(Long issueId);

    List<BookIssue> getMemberIssues(Long memberId);

    List<BookIssue> getOverdueBooks();
}
