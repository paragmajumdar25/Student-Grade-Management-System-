import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = FileHandler.loadStudents();

        int choice;

        do {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Subject Marks");
            System.out.println("3. Add Attendance");
            System.out.println("4. View Students");
            System.out.println("5. Class Average GPA");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    students.add(new Student(id, name));

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    Student foundStudent = null;

                    for (Student s : students) {
                        if (s.getId() == sid) {
                            foundStudent = s;
                            break;
                        }
                    }

                    if (foundStudent != null) {
                        System.out.print("Enter Subject Name: ");
                        String subject = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        foundStudent.addSubject(subject, marks);

                        System.out.println("Subject marks added successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }

                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int attId = sc.nextInt();

                    Student attStudent = null;

                    for (Student s : students) {
                        if (s.getId() == attId) {
                            attStudent = s;
                            break;
                        }
                    }

                    if (attStudent != null) {
                        System.out.print("Enter Attendance Percentage: ");
                        int attendance = sc.nextInt();

                        attStudent.setAttendance(attendance);

                        System.out.println("Attendance updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }

                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available!");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No students available!");
                    } else {
                        double total = 0;

                        for (Student s : students) {
                            total += s.calculateGPA();
                        }

                        double average = total / students.size();

                        System.out.printf("Class Average GPA: %.2f\n", average);
                    }
                    break;

                case 6:
                    FileHandler.saveStudents(students);
                    System.out.println("Data saved. Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}