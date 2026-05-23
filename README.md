# 🎮 WordMaster Pro

A console-based Word Guessing Game developed using Java, JDBC, MySQL, and DAO Architecture.

This project demonstrates Object-Oriented Programming (OOP), Database Connectivity, Exception Handling, and Clean Project Structure.

---

# 🚀 Features

✅ User Registration & Login  
✅ Random Word Generation  
✅ Category-Based Words  
✅ Difficulty Levels  
✅ Lives System  
✅ Score Calculation  
✅ Leaderboard System  
✅ MySQL Database Integration  
✅ JDBC Connectivity  
✅ DAO Pattern Architecture  
✅ Exception Handling  
✅ Clean Modular Code Structure  

---

# 🛠 Technologies Used

- Java
- JDBC
- MySQL
- XAMPP
- DAO Design Pattern
- OOP Concepts

---

# 📁 Project Structure

```text
WordMasterPro/
│
├── src/
│   ├── model/
│   │      User.java
│   │      Word.java
│   │      Score.java
│   │
│   ├── dao/
│   │      UserDAO.java
│   │      WordDAO.java
│   │      ScoreDAO.java
│   │
│   ├── service/
│   │      AuthService.java
│   │      GameService.java
│   │
│   ├── util/
│   │      DBConnection.java
│   │
│   └── main/
│          Main.java
│
├── database/
│      schema.sql
│
└── README.md

⚙️ Setup Instructions
1️⃣ Install Required Software
Java JDK 8 or above
XAMPP
MySQL Connector/J
IDE (IntelliJ IDEA / Eclipse / VS Code)
2️⃣ Start XAMPP

Open XAMPP Control Panel and start:

Apache
MySQL
3️⃣ Create Database

Open phpMyAdmin and run:

CREATE DATABASE wordmasterpro;
USE wordmasterpro;
4️⃣ Run SQL Schema

Execute the schema.sql file located inside:

database/schema.sql

This will create:

users table
words table
scores table

and insert sample words.

5️⃣ Add JDBC Driver

Download MySQL Connector/J:

https://dev.mysql.com/downloads/connector/j/

Add the .jar file into your project's library section.

▶️ How To Run
Open project in IDE
Configure MySQL credentials in:
src/util/DBConnection.java
Run:
src/main/Main.java
🎮 Game Flow
Main Menu
1. Register
2. Login
3. Leaderboard
4. Exit
Gameplay
User logs in
Random word is fetched from database
Player guesses letters
Correct guesses reveal letters
Wrong guesses reduce lives
Score is calculated based on remaining lives
🧠 Concepts Used
Object-Oriented Programming
Classes & Objects
Encapsulation
Constructors
Getters & Setters
JDBC
Database Connectivity
Prepared Statements
ResultSet Handling
DAO Pattern
UserDAO
WordDAO
ScoreDAO
Exception Handling
Try-Catch
Input Validation
🏆 Leaderboard

The game stores scores in MySQL database and displays highest scores of users.

🔥 Future Enhancements
Multiplayer Mode
Timer System
Hint System
Admin Panel
Difficulty Selection
Sound Effects
GUI Version (JavaFX/Swing)
Online Multiplayer
REST API Integration
📸 Sample Output
🎮 WORDMASTER PRO

1. Register
2. Login
3. Leaderboard
4. Exit

Choose Option: 2

===== LOGIN =====

Enter Username: harshit
Enter Password: 1234

Welcome, harshit

===== WORD GUESS GAME =====

Category: Programming
Difficulty: Easy

Word: _ _ _ _
Lives Left: 6

Guess a Letter: j

✅ Correct Guess!
👨‍💻 Author

Harshit Doshi
