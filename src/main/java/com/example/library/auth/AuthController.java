package com.example.library.auth;

import com.example.library.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Set<String> VALID_ROLES = Set.of("ADMIN");

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String role = body.get("role") == null ? "" : body.get("role").toUpperCase();

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body("email and password are required");
        }
        if (!VALID_ROLES.contains(role)) {
            return ResponseEntity.badRequest().body("role must be ADMIN");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        userRepository.save(user);

        return ResponseEntity.ok(role + " registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        return userRepository.findByEmail(email)
            .map(user -> {
                if (!passwordEncoder.matches(password, user.getPassword())) {
                    return ResponseEntity.status(403).body((Object) "Invalid password");
                }
                String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
                return ResponseEntity.ok((Object) Map.of("token", token, "role", user.getRole()));
            })
            .orElseGet(() -> ResponseEntity.status(404).body("User not found"));
    }
}
