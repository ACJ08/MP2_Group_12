CREATE DATABASE WebApplicationDB;
USE WebApplicationDB;


CREATE TABLE account (
    user_name VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    user_role ENUM('user', 'admin', 'super_admin') NOT NULL
);

/*
ON DELETE CASCADE is a referential action used in SQL when defining foreign keys. 
It ensures that if a referenced row in the parent table is deleted, all related rows in the child 
table are also automatically deleted.
*/

CREATE TABLE posts (
    user_name VARCHAR(50),
    post1 VARCHAR(200),
    post2 VARCHAR(200),
    post3 VARCHAR(200),
    post4 VARCHAR(200),
    post5 VARCHAR(200),
    FOREIGN KEY (user_name) REFERENCES account(user_name) ON DELETE CASCADE
);

CREATE TABLE follows (
    user_name VARCHAR(50),
    follow1 VARCHAR(50),
    follow2 VARCHAR(50),
    follow3 VARCHAR(50),
    FOREIGN KEY (user_name) REFERENCES account(user_name) ON DELETE CASCADE
);

# Insert Sample Data for Testing

INSERT INTO account (user_name, password, user_role) VALUES
('user1', 'password123', 'user'),
('user2', 'password123', 'user'),
('admin1', 'adminpass', 'admin'),
('superadmin1', 'superpass', 'super_admin');

INSERT INTO posts (user_name, post1, post2, post3, post4, post5) VALUES
('user1', 'Hello world!', 'My first post', 'Enjoying coding', 'Learning JSP', 'Database setup done'),
('user2', 'Test post 1', 'Test post 2', 'Test post 3', NULL, NULL);

INSERT INTO follows (user_name, follow1, follow2, follow3) VALUES
('user1', 'user2', NULL, NULL),
('user2', 'user1', NULL, NULL);


# Test the Database
SELECT * FROM account;
SELECT * FROM posts;
SELECT * FROM follows;


