# Student-management-system
Java Swing-Based Student Management System

📝 Overview This is a Java GUI-based application that simulates a simple Student Management System using Java Swing. It allows administrators to register students and view results, while students can log in, view available courses, take multiple-choice exams, and see their scores.

🔧 Features 👤 Admin: Register new students using Name and ID.

View all student exam results.

🎓 Student: Log in using Name and ID.

View list of available courses.

Take MCQ-based tests per course.

View individual results after the test.

💻 Technologies Used Java SE

Java Swing (for GUI)

Object-Oriented Programming (OOP)

🚀 How to Run Compile all .java files:

bash Copy Edit javac *.java Run the application:

bash Copy Edit java Main 📚 Preloaded Courses & Questions The system loads the following courses by default:

Java

btech it

btech cse

BCA

Each course contains 5 preloaded Java MCQ questions covering basic concepts.

🗂 Folder Structure css Copy Edit StudentManagementSystemGUI/ ├── AdminPanel.java ├── Course.java ├── Exam.java ├── Main.java ├── Question.java ├── Result.java ├── StudentLogin.java ├── StudentPanel.java ├── StudentRegister.java ├── StudentRegistry.java ├── WelcomeScreen.java 🌟 Future Enhancements Add persistent storage (file system or database).

Password-based login for students and admin.

Dynamic question addition by admin.

Add timer functionality for exams.

Export results to PDF or CSV.
