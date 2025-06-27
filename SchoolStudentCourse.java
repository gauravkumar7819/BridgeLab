import java.util.*;

class Course {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Course(String name) { this.name = name; }

    public String getName() { return name; }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
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
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students = new ArrayList<>();

    public School(String name) { this.name = name; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

public class SchoolStudentCourse {
    public static void main(String[] args) {
        School school = new School("BridgeLab School");
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        school.addStudent(alice);
        school.addStudent(bob);

        Course math = new Course("Math");
        Course science = new Course("Science");

        alice.enrollCourse(math);
        alice.enrollCourse(science);
        bob.enrollCourse(math);

        alice.showCourses();
        bob.showCourses();
        math.showEnrolledStudents();
        science.showEnrolledStudents();
        school.showStudents();
    }
}