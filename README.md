# LibraryOS

A single, self-contained Spring Boot application: backend (auth, books,
members, book issues) and frontend (one HTML file) in one project, on one
port. No Kafka, no multi-module confusion, no separate frontend server.

## Run it

```bash
mvnw spring-boot:run          # Windows: mvnw.cmd spring-boot:run
```

Then open:

```
http://localhost:8080
```

The login page loads automatically.

## First-time use

The database is in-memory H2 and resets every time you restart the app — but
it comes pre-loaded with sample data every time via `data.sql`, so you don't
need to register anything to get started.

**Admin login:**
```
Email:    admin@library.com
Password: admin123
```

Sign in directly with these credentials. You'll see:
- 20 books across Programming, Fiction, Science, History, Biography, Self-Help, Mathematics, and Computer Science
- 15 members (12 students, 3 faculty — two of the faculty are marked inactive)
- 12 book issue records, including some overdue and some returned with fines, so the dashboard stats have real numbers to show immediately

If you want to add more admin/teacher accounts later, use the **"Create one"**
link on the login screen.

## What's inside

- `com.example.library.auth` — User entity/repository, `/auth/register`, `/auth/login`
- `com.example.library.book` — Book entity/repository, `/api/books` (GET, POST, PUT /{id}, DELETE /{id})
- `com.example.library.member` — Member entity/repository, `/api/members` (GET, POST, PUT /{id}, DELETE /{id})
- `com.example.library.issue` — BookIssue entity/repository, `/books/issue`, `/books/return/{id}`, `/books/all-issues`, `/books/my-books/{memberId}`
- `com.example.library.config` — JwtUtil (token generation, currently informational — routes aren't locked behind it yet) and SecurityConfig (permits all routes, disables Spring Security's default login wall, enables CORS)
- `src/main/resources/static/index.html` — the entire frontend, served automatically by Spring Boot

## Notes

- H2 console: `http://localhost:8080/h2-console`, JDBC URL `jdbc:h2:mem:librarydb`, user `sa`, blank password.
- All API routes are open (no auth required) for simplicity. The login flow issues a JWT and the frontend sends it as `Authorization: Bearer <token>` on every request, but the backend doesn't currently enforce it — wire that into `SecurityConfig` if you need real access control.
- No Kafka, no other services, no docker-compose required. Just this one app.
