package collectors;

import java.util.*;
import static java.util.stream.Collectors.*;

public class StudentResultAnalyzer {
    static class Student {
        private String name;
        private int grade;
        private double score;

        public Student(String name, int grade, double score) {
            this.name = name;
            this.grade = grade;
            this.score = score;
        }

        public String getName() { return name; }
        public int getGrade() { return grade; }
        public double getScore() { return score; }
    }

    public Map<Integer, List<String>> groupStudentsByGrade(List<Student> students) {
        return students.stream()
            .collect(groupingBy(
                Student::getGrade,
                mapping(Student::getName, toList())
            ));
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 10, 85.5),
            new Student("Bob", 9, 92.0),
            new Student("Charlie", 10, 78.5)
        );

        StudentResultAnalyzer analyzer = new StudentResultAnalyzer();
        Map<Integer, List<String>> groupedStudents = analyzer.groupStudentsByGrade(students);
        groupedStudents.forEach((grade, names) -> 
            System.out.println("Grade " + grade + ": " + names));
    }
}