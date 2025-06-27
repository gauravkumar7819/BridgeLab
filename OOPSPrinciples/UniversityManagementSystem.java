import java.util.*;

class Professor {
    private String name;
    public Professor(String name) { this.name = name; }
    public String getName() { return name; }
}

class Course {
    private String name;
    private Professor professor;
    private List<Student> students = new ArrayList<>();
    public Course(String name) { this.name = name; }
    public String getName() { return name; }
    public void assignProfessor(Professor prof) {
        this.professor = prof;
        System.out.println(prof.getName() + " assigned to " + name);
    }
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this);
        }
    }
    public void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) System.out.println("- " + s.getName());
    }
}

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }
    public void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) System.out.println("- " + c.getName());
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Professor prof = new Professor("Dr. Smith");
        Course math = new Course("Math");

        math.assignProfessor(prof);
        s1.enrollCourse(math);
        s2.enrollCourse(math);

        s1.showCourses();
        math.showStudents();
    }
}