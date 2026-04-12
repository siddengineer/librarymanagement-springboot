// package com.example.library_db.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// import java.math.BigDecimal;
// import java.time.LocalDate;

// @Entity
// @Getter
// @Setter
// @Table(name = "book_issues")
// public class BookIssue {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "book_id")
//     private Book book;

//     @ManyToOne
//     @JoinColumn(name = "member_id")
//     private Member member;

//     private LocalDate issueDate;
//     private LocalDate dueDate;
//     private LocalDate returnDate;

//     private BigDecimal fineAmount = BigDecimal.ZERO;
// }


package com.example.library_db.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "book_issues")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 WHICH BOOK
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // 🔥 WHICH STUDENT
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private BigDecimal fineAmount;

    // GETTERS + SETTERS

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(BigDecimal fineAmount) {
        this.fineAmount = fineAmount;
    }
}



