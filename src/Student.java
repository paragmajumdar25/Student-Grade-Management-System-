import java.util.*;

public class Student {

    private int id;
    private String name;
    private HashMap<String, Integer> subjects;
    private int attendance;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new HashMap<>();
        this.attendance = 100;
    }

    // Get student ID
    public int getId() {
        return id;
    }

    // Add subject and marks
    public void addSubject(String subject, int marks) {

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! (0-100 only)");
            return;
        }

        if (subjects.containsKey(subject)) {
            System.out.println("Subject already exists!");
            return;
        }

        subjects.put(subject, marks);
    }

    // Set attendance
    public void setAttendance(int attendance) {

        if (attendance < 0 || attendance > 100) {
            System.out.println("Invalid attendance! (0-100 only)");
            return;
        }

        this.attendance = attendance;
    }

    // Get attendance
    public int getAttendance() {
        return attendance;
    }

    // GPA calculation
    public double calculateGPA() {
        return Grade.calculateGPA(subjects);
    }

    // Check if student is at risk
    public boolean isAtRisk() {
        return calculateGPA() < 5.0 || attendance < 75;
    }

    // Display student details
    public void display() {

        System.out.println("------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);

        System.out.println("Subjects:");

        for (String subject : subjects.keySet()) {
            System.out.println(subject + " : " + subjects.get(subject));
        }

        System.out.printf("GPA: %.2f\n", calculateGPA());

        System.out.println("Attendance: " + attendance + "%");

        if (isAtRisk()) {
            System.out.println("Status: AT RISK");
        } else {
            System.out.println("Status: SAFE");
        }

        System.out.println("------------------------");
    }

    // Convert data to CSV format
    public String toCSV() {

        StringBuilder sb = new StringBuilder();

        sb.append(id)
          .append(",")
          .append(name)
          .append(",")
          .append(attendance);

        for (String subject : subjects.keySet()) {
            sb.append(",")
              .append(subject)
              .append(":")
              .append(subjects.get(subject));
        }

        return sb.toString();
    }
}