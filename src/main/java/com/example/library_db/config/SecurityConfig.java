// package com.example.library_db.config;

// import org.springframework.context.annotation.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.*;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.security.crypto.bcrypt.*;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {

//     private final JwtFilter jwtFilter;

//     public SecurityConfig(JwtFilter jwtFilter) {
//         this.jwtFilter = jwtFilter;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http.csrf().disable()
//                 .authorizeHttpRequests(auth -> auth

//                         // Public
//                         .requestMatchers("/auth/**").permitAll()

//                         // ADMIN only
//                         .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")

//                         // TEACHER + ADMIN
//                         .requestMatchers("/api/books/**").hasAnyRole("ADMIN", "TEACHER")

//                         .anyRequest().authenticated()
//                 )
//                 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }










package com.example.library_db.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity   // ✅ Enables @PreAuthorize (VERY IMPORTANT)
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // ✅ Disable CSRF for APIs

            .authorizeHttpRequests(auth -> auth

                // 🔓 Public APIs (No login required)
                .requestMatchers("/auth/**").permitAll()

                // 👑 ADMIN only
                .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")

                // 👨‍🏫 TEACHER + ADMIN (manage books)
                .requestMatchers("/api/books/**").hasAnyRole("ADMIN", "TEACHER")

                // 👨‍🎓 STUDENT + TEACHER + ADMIN (view, borrow, return)
                .requestMatchers("/api/student/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")

                // 🔐 Everything else needs authentication
                .anyRequest().authenticated()
            )

            // ✅ Add JWT filter
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // 🔐 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}