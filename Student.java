 
import java.util.*;

// Supporting Classes
class Subject {
    private String name;
    public Subject(String name) { this.name = name; }
    public String getName() { return name; }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;
    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Course {
    private String name;
    private List<Subject> subjects = new ArrayList<>();
    public Course(String name) { this.name = name; }
    public String getName() { return name; }
    public List<Subject> getSubjects() { return subjects; }
    public void addSubject(Subject subject) { subjects.add(subject); }
}

class ExamResult {
    private String studentName;
    private String subjectName;
    private int score;
    public ExamResult(String studentName, String subjectName, int score) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student: " + studentName + ", Subject: " + subjectName + ", Score: " + score;
    }
}

// Abstract User class
abstract class User {
    protected String name;
    protected String email;
    protected String loginId;
    protected String password;

    public User(String name, String email, String loginId, String password) {
        this.name = name;
        this.email = email;
        this.loginId = loginId;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLoginId() { return loginId; }
    public boolean checkPassword(String pwd) {
        return this.password.equals(pwd);
    }

    public abstract void displayMenu();
}

class Student extends User {
    private int age;
    private Course selectedCourse;
    private List<Subject> selectedSubjects = new ArrayList<>();
    private List<ExamResult> examResults = new ArrayList<>();

    public Student(String name, String email, String loginId, String password, int age) {
        super(name, email, loginId, password);
        this.age = age;
    }

    public void selectCourse(Course course) {
        this.selectedCourse = course;
    }

    public void selectSubject(Subject subject) {
        if (!selectedSubjects.contains(subject)) {
            selectedSubjects.add(subject);
        }
    }

    public void addExamResult(ExamResult result) {
        examResults.add(result);
    }

    public Course getSelectedCourse() { return selectedCourse; }
    public List<Subject> getSelectedSubjects() { return selectedSubjects; }
    public List<ExamResult> getExamResults() { return examResults; }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Student Menu ===");
        System.out.println("1. View Courses");
        System.out.println("2. Select Course");
        System.out.println("3. Choose Subjects");
        System.out.println("4. Take Exam");
        System.out.println("5. View Results");
        System.out.println("6. Logout");
    }
}

class Admin extends User {
    public Admin(String name, String email, String loginId, String password) {
        super(name, email, loginId, password);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Course");
        System.out.println("2. Add Subject");
        System.out.println("3. View Courses");
        System.out.println("4. View Students");
        System.out.println("5. View Results");
        System.out.println("6. Logout");
    }
}

public class StudentPortalLogin {
    private static List<Student> students = new ArrayList<>();
    private static Admin admin = new Admin("Admin", "admin@sms.com", "admin", "admin123");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new StudentPortalLogin().run();
    }

    private void run() {
        while (true) {
            System.out.println("\n--- Welcome to the Portal ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Student Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> studentRegistration();
                case 3 -> studentLogin();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pwd = scanner.nextLine();

        if (admin.getLoginId().equals(id) && admin.checkPassword(pwd)) {
            System.out.println("Welcome Admin!");
            admin.displayMenu();
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private void studentRegistration() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Login ID: ");
        String id = scanner.nextLine();
        System.out.print("Password: ");
        String pwd = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getLoginId().equals(id)) {
                System.out.println("Login ID already taken.");
                return;
            }
        }

        students.add(new Student(name, email, id, pwd, age));
        System.out.println("Registration Successful!");
    }

    private void studentLogin() {
        System.out.print("Login ID: ");
        String id = scanner.nextLine();
        System.out.print("Password: ");
        String pwd = scanner.nextLine();

        for (Student s : students) {
            if (s.getLoginId().equals(id) && s.checkPassword(pwd)) {
                System.out.println("Welcome " + s.getName());
                s.displayMenu();
                return;
            }
        }
        System.out.println("Invalid credentials");
    }
}
