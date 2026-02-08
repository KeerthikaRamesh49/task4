-- MySQL Database Schema for Task 4 Application
-- Create this database before running the Java application

-- ============================================
-- CREATE DATABASE
-- ============================================
-- Execute this first, then select the database
CREATE DATABASE IF NOT EXISTS myapp_db;
USE myapp_db;

-- ============================================
-- CREATE USERS TABLE
-- ============================================
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ============================================
-- CREATE USER PROFILES TABLE
-- ============================================
CREATE TABLE IF NOT EXISTS user_profiles (
    profile_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    bio VARCHAR(500),
    profile_picture VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(50),
    country VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- ============================================
-- CREATE SETTINGS TABLE
-- ============================================
CREATE TABLE IF NOT EXISTS user_settings (
    setting_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    theme VARCHAR(20) DEFAULT 'light',
    notifications_enabled BOOLEAN DEFAULT TRUE,
    email_notifications BOOLEAN DEFAULT TRUE,
    language VARCHAR(20) DEFAULT 'en',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- ============================================
-- INSERT SAMPLE DATA
-- ============================================
-- Sample user data (passwords stored as plain text for demo - use hashing in production!)
INSERT INTO users (username, password, email, first_name, last_name) VALUES
('john_doe', 'password123', 'john@example.com', 'John', 'Doe'),
('jane_smith', 'mypass456', 'jane@example.com', 'Jane', 'Smith'),
('admin', 'admin123', 'admin@example.com', 'Admin', 'User');

-- Sample profile data
INSERT INTO user_profiles (user_id, bio, phone_number, city, country) VALUES
(1, 'Software developer and tech enthusiast', '555-0001', 'New York', 'USA'),
(2, 'Designer and creative thinker', '555-0002', 'Los Angeles', 'USA'),
(3, 'Administrator', '555-0003', 'San Francisco', 'USA');

-- Sample settings data
INSERT INTO user_settings (user_id, theme, notifications_enabled, language) VALUES
(1, 'dark', TRUE, 'en'),
(2, 'light', TRUE, 'en'),
(3, 'dark', TRUE, 'en');

-- ============================================
-- DISPLAY TABLES
-- ============================================
-- View all tables (execute these separately to verify)
-- SELECT * FROM users;
-- SELECT * FROM user_profiles;
-- SELECT * FROM user_settings;

-- ============================================
-- SQL QUERIES FOR JAVA APPLICATION
-- ============================================

-- Query 1: Authenticate user (used in LoginForm.java)
-- SELECT * FROM users WHERE username = 'john_doe' AND password = 'password123';

-- Query 2: Get user profile
-- SELECT * FROM user_profiles WHERE user_id = 1;

-- Query 3: Get user settings
-- SELECT * FROM user_settings WHERE user_id = 1;

-- Query 4: Update user profile
-- UPDATE user_profiles SET bio = 'Updated bio' WHERE user_id = 1;

-- Query 5: Update user settings
-- UPDATE user_settings SET theme = 'dark' WHERE user_id = 1;

-- Query 6: Delete user (cascades to profiles and settings)
-- DELETE FROM users WHERE user_id = 1;
