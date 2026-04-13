// package com.example.library_db.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import org.hibernate.annotations.CreationTimestamp;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Getter
// @Setter
// @Table(name = "books")
// public class Book {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String title;

//     @Column(nullable = false)
//     private String author;

//     @Column(unique = true, nullable = false)
//     private String isbn;

//     private String category;

//     @Column(nullable = false)
//     private int totalCopies;

//     @Column(nullable = false)
//     private int availableCopies;

//     @CreationTimestamp
//     private LocalDateTime createdAt;

//     @OneToMany(mappedBy = "book")
//     private List<BookIssue> issues;
// }


// package com.example.library_db.entity;

// import com.fasterxml.jackson.annotation.JsonIgnore; // ✅ important
// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import org.hibernate.annotations.CreationTimestamp;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Getter
// @Setter
// @Table(name = "books")
// public class Book {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String title;

//     @Column(nullable = false)
//     private String author;

//     @Column(unique = true, nullable = false)
//     private String isbn;

//     private String category;

//     @Column(nullable = false)
//     private int totalCopies;

//     @Column(nullable = false)
//     private int availableCopies;

//     @CreationTimestamp
//     private LocalDateTime createdAt;

//     // 🔥 FIX: Prevent infinite recursion
//     @OneToMany(mappedBy = "book")
//     @JsonIgnore
//     private List<BookIssue> issues;
// }






package com.example.book.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String category;

    private int totalCopies;
    private int availableCopies;

    // GETTERS + SETTERS

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}