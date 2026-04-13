// package com.example.library_db.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// import java.time.LocalDate;
// import java.util.List;

// @Entity
// @Getter
// @Setter
// @Table(name = "members")
// public class Member {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @Column(unique = true)
//     private String email;

//     private String phone;

//     @Enumerated(EnumType.STRING)
//     private MembershipType membershipType;

//     private LocalDate membershipStartDate;

//     private boolean active = true;

//     @OneToMany(mappedBy = "member")
//     private List<BookIssue> issues;
// }



// package com.example.library_db.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "members")
// public class Member {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String email;

//     private String password; // ✅ ADD THIS

//     private boolean active;

//     // ✅ GETTERS + SETTERS

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     // 🔥 IMPORTANT
//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public boolean isActive() {
//         return active;
//     }

//     public void setActive(boolean active) {
//         this.active = active;
//     }
//     // PHONE
// public String getPhone() {
//     return phone;
// }

// public void setPhone(String phone) {
//     this.phone = phone;
// }

// // MEMBERSHIP TYPE
// public String getMembershipType() {
//     return membershipType;
// }

// public void setMembershipType(String membershipType) {
//     this.membershipType = membershipType;
// }
// }





package com.example.member.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private String password;

    private boolean active;

    // ✅ ADD THESE
    private String phone;
    private String membershipType;

    // GETTERS + SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // PHONE
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // MEMBERSHIP TYPE
    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}