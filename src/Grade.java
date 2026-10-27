import java.util.*;

public class Grade {

    // Convert marks into grade point
    public static int getGradePoint(int marks) {

        if (marks >= 90)
            return 10;
        else if (marks >= 80)
            return 9;
        else if (marks >= 70)
            return 8;
        else if (marks >= 60)
            return 7;
        else if (marks >= 50)
            return 6;
        else
            return 0;
    }

    // Calculate GPA
    public static double calculateGPA(HashMap<String, Integer> subjects) {

        if (subjects.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (int marks : subjects.values()) {
            total += getGradePoint(marks);
        }

        return (double) total / subjects.size();
    }
}