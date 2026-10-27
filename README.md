Student Grade Management System

A Java-based application for managing student records, subject marks, GPA calculations, and attendance tracking. The system identifies students who may be at academic risk and stores records using CSV file handling.

Features

- Student Management: Add and view student records.
- Grade Management: Record subject marks and calculate student grades/GPA.
- Attendance Tracking: Maintain student attendance records.
- At-Risk Detection: Identify students who require attention based on low attendance and/or academic performance.
- Class Average GPA: Calculate the class average GPA.
- Data Persistence: Store student records in a CSV file so data can be retained between program runs.

Tech Stack

- Language: Java
- Data Storage: CSV files
- Development Environment: Visual Studio Code
- Version Control: Git and GitHub

Project Structure

Student-Grade-Management-System/
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── Grade.java
│   └── FileHandler.java
├── data/
│   └── students.csv
├── docs/
│   ├── Design.txt
│   ├── Testcase.txt
│   ├── BugReport.txt
│   └── Optimization.txt
└── README.md

How to Run

1. Install the Java Development Kit (JDK).
2. Clone or download this repository.
3. Open the project folder in Visual Studio Code.
4. Open the "src" folder and run "Main.java", or compile and run the program from the project root:

javac src/*.java
java -cp src Main
