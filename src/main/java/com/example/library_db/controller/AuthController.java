package com.example.library_db.controller;

import com.example.library_db.config.JwtUtil;
import com.example.library_db.entity.User;
import com.example.library_db.entity.Member;
import com.example.library_db.repository.UserRepository;
import com.example.library_db.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    private static final Set<String> USER_ROLES = Set.of("ADMIN", "TEACHER");

    public AuthController(UserRepository userRepository,
                          MemberRepository memberRepository,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> req) {

        String role = req.get("role").toUpperCase();

        // 🔥 ADMIN / TEACHER → USER TABLE
        if (USER_ROLES.contains(role)) {

            User user = new User();
            user.setEmail(req.get("email"));
            user.setPassword(passwordEncoder.encode(req.get("password")));
            user.setRole(role);

            userRepository.save(user);

            return ResponseEntity.ok(role + " registered in USER table");
        }

        // 🔥 STUDENT → MEMBER TABLE (WITH PASSWORD)
        if (role.equals("STUDENT")) {

            Member member = new Member();
            member.setName(req.get("name"));
            member.setEmail(req.get("email"));
            member.setPassword(passwordEncoder.encode(req.get("password"))); // ✅ important
            member.setActive(true);

            memberRepository.save(member);

            return ResponseEntity.ok("Student registered in MEMBER table");
        }

        return ResponseEntity.badRequest().body("Invalid role");
    }

    // ✅ LOGIN (COMMON FOR BOTH)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {

        String email = req.get("email");
        String password = req.get("password");

        // 🔹 1. Try USER login
        var userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {

            User user = userOpt.get();

            if (!passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.status(403).body("Invalid password");
            }

            String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "role", user.getRole()
            ));
        }

        // 🔹 2. Try STUDENT login (MEMBER TABLE)
        var memberOpt = memberRepository.findByEmail(email);
        if (memberOpt.isPresent()) {

            Member member = memberOpt.get();

            if (!passwordEncoder.matches(password, member.getPassword())) {
                return ResponseEntity.status(403).body("Invalid password");
            }

            String token = jwtUtil.generateToken(member.getEmail(), "STUDENT");

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "role", "STUDENT"
            ));
        }

        return ResponseEntity.status(404).body("User not found");
    }
}