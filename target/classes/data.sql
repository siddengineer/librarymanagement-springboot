-- Auto-generated seed data for LibraryOS
-- Admin login: admin@library.com / admin123

-- BOOKS
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (1, 'Clean Code', 'Robert C. Martin', '978-0-13-235088-4', 'Programming', 5, 2);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (2, 'The Pragmatic Programmer', 'Andrew Hunt', '978-0-13-595705-9', 'Programming', 4, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (3, 'Introduction to Algorithms', 'Thomas H. Cormen', '978-0-26-204630-5', 'Computer Science', 3, 0);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (4, 'Design Patterns', 'Erich Gamma', '978-0-20-163361-0', 'Programming', 2, 0);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (5, 'Artificial Intelligence: A Modern Approach', 'Stuart Russell', '978-0-13-461099-3', 'Computer Science', 4, 2);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (6, 'The Alchemist', 'Paulo Coelho', '978-0-06-112241-5', 'Fiction', 6, 3);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (7, '1984', 'George Orwell', '978-0-45-152493-5', 'Fiction', 5, 0);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (8, 'To Kill a Mockingbird', 'Harper Lee', '978-0-06-093546-7', 'Fiction', 4, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (9, 'A Brief History of Time', 'Stephen Hawking', '978-0-55-338016-3', 'Science', 3, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (10, 'Cosmos', 'Carl Sagan', '978-0-34-553943-4', 'Science', 4, 2);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (11, 'Sapiens', 'Yuval Noah Harari', '978-0-06-231609-7', 'History', 6, 4);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (12, 'Guns, Germs, and Steel', 'Jared Diamond', '978-0-39-331755-8', 'History', 3, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (13, 'The Diary of a Young Girl', 'Anne Frank', '978-0-55-329698-3', 'Biography', 4, 2);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (14, 'Steve Jobs', 'Walter Isaacson', '978-1-45-164853-9', 'Biography', 5, 0);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (15, 'Atomic Habits', 'James Clear', '978-1-84-794183-1', 'Self-Help', 8, 3);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (16, 'The Power of Habit', 'Charles Duhigg', '978-0-81-298160-5', 'Self-Help', 5, 2);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (17, 'Think and Grow Rich', 'Napoleon Hill', '978-1-58-542433-7', 'Self-Help', 4, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (18, 'Discrete Mathematics and Its Applications', 'Kenneth Rosen', '978-0-07-338309-5', 'Mathematics', 3, 1);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (19, 'Higher Engineering Mathematics', 'B. S. Grewal', '978-8-19-332849-4', 'Mathematics', 7, 5);
INSERT INTO books (id, title, author, isbn, category, total_copies, available_copies) VALUES (20, 'Computer Networks', 'Andrew S. Tanenbaum', '978-0-13-212695-3', 'Computer Science', 4, 0);

-- MEMBERS
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (1, 'Aarav Sharma', 'user1@college.edu', '+91 98765 12345', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (2, 'Priya Patel', 'user2@college.edu', '+91 98765 12346', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (3, 'Rohan Deshmukh', 'user3@college.edu', '+91 98765 12347', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (4, 'Sneha Kulkarni', 'user4@college.edu', '+91 98765 12348', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (5, 'Aditya Joshi', 'user5@college.edu', '+91 98765 12349', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (6, 'Kavya Nair', 'user6@college.edu', '+91 98765 12350', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (7, 'Rahul Verma', 'user7@college.edu', '+91 98765 12351', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (8, 'Ananya Gupta', 'user8@college.edu', '+91 98765 12352', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (9, 'Vikram Singh', 'user9@college.edu', '+91 98765 12353', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (10, 'Neha Mehta', 'user10@college.edu', '+91 98765 12354', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (11, 'Arjun Patil', 'user11@college.edu', '+91 98765 12355', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (12, 'Pooja Shah', 'user12@college.edu', '+91 98765 12356', 'STUDENT', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (13, 'Karan Malhotra', 'user13@college.edu', '+91 98765 12357', 'FACULTY', 'member123', TRUE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (14, 'Ishita Roy', 'user14@college.edu', '+91 98765 12358', 'FACULTY', 'member123', FALSE);
INSERT INTO members (id, name, email, phone, membership_type, password, active) VALUES (15, 'Manish Yadav', 'user15@college.edu', '+91 98765 12359', 'FACULTY', 'member123', FALSE);

-- USERS (admin only)
INSERT INTO users (id, email, password, role) VALUES (1, 'admin@library.com', '$2a$10$KoAHVP8QLWOU9ZVlOVLHiuy8bpyli4sMn4S0nMQ7t2v1Hip2IbAdm', 'ADMIN');

-- BOOK ISSUES
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (1, 3, 1, '2026-05-20', '2026-05-27', '2026-05-27', 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (2, 4, 2, '2026-05-22', '2026-05-29', '2026-05-31', 10);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (3, 7, 3, '2026-05-25', '2026-06-01', NULL, 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (4, 14, 4, '2026-05-28', '2026-06-04', NULL, 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (5, 20, 5, '2026-05-30', '2026-06-06', NULL, 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (6, 1, 6, '2026-06-01', '2026-06-08', '2026-06-07', 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (7, 2, 7, '2026-06-02', '2026-06-09', '2026-06-12', 15);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (8, 5, 8, '2026-06-03', '2026-06-10', NULL, 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (9, 6, 9, '2026-06-04', '2026-06-11', '2026-06-11', 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (10, 8, 10, '2026-06-05', '2026-06-12', '2026-06-15', 20);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (11, 9, 11, '2026-06-06', '2026-06-13', NULL, 0);
INSERT INTO book_issues (id, book_id, member_id, issue_date, due_date, return_date, fine_amount) VALUES (12, 15, 12, '2026-06-07', '2026-06-14', '2026-06-14', 0);

-- Keep auto-increment counters ahead of the seeded IDs
ALTER TABLE books ALTER COLUMN id RESTART WITH 21;
ALTER TABLE members ALTER COLUMN id RESTART WITH 16;
ALTER TABLE users ALTER COLUMN id RESTART WITH 2;
ALTER TABLE book_issues ALTER COLUMN id RESTART WITH 13;