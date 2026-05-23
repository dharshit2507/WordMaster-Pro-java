CREATE DATABASE IF NOT EXISTS wordmasterpro;
USE wordmasterpro;
-- USERS TABLE
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
-- WORDS TABLE
CREATE TABLE words (
    id INT PRIMARY KEY AUTO_INCREMENT,
    word VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    difficulty VARCHAR(20)
);
-- SCORES TABLE
CREATE TABLE scores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    score INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
-- INSERT SAMPLE WORDS
INSERT INTO words(word, category, difficulty)
VALUES ('java', 'Programming', 'Easy'),
    ('database', 'Technology', 'Medium'),
    ('inheritance', 'Programming', 'Hard'),
    ('polymorphism', 'Programming', 'Hard'),
    ('algorithm', 'Technology', 'Medium'),
    ('compiler', 'Technology', 'Easy'),
    ('elephant', 'Animal', 'Easy'),
    ('alligator', 'Animal', 'Medium'),
    ('encyclopedia', 'General', 'Hard');