import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "../data/students.csv";

    // Save students to CSV file
    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    // Load students from CSV file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int attendance = Integer.parseInt(parts[2]);

                Student student = new Student(id, name);
                student.setAttendance(attendance);

                for (int i = 3; i < parts.length; i++) {

                    String[] subjectData = parts[i].split(":");

                    String subject = subjectData[0];
                    int marks = Integer.parseInt(subjectData[1]);

                    student.addSubject(subject, marks);
                }

                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error loading file!");
        }

        return students;
    }
}