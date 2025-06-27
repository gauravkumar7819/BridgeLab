import java.util.*;

class Faculty {
    private String name;
    public Faculty(String name) { this.name = name; }
    public String getName() { return name; }
}

class Department {
    private String name;
    public Department(String name) { this.name = name; }
    public String getName() { return name; }
}

class University {
    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name) { this.name = name; }

    public void addDepartment(Department dept) { departments.add(dept); }
    public void addFaculty(Faculty faculty) { faculties.add(faculty); }

    public void showDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department d : departments) System.out.println("- " + d.getName());
    }

    public void showFaculties() {
        System.out.println("Faculties in " + name + ":");
        for (Faculty f : faculties) System.out.println("- " + f.getName());
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("University " + name + " deleted. All departments removed.");
    }
}

public class UniversityDepartmentFaculty {
    public static void main(String[] args) {
        University uni = new University("BridgeLab University");
        Department cs = new Department("Computer Science");
        Department math = new Department("Mathematics");
        uni.addDepartment(cs);
        uni.addDepartment(math);

        Faculty profA = new Faculty("Prof. Alice");
        Faculty profB = new Faculty("Prof. Bob");
        uni.addFaculty(profA);
        uni.addFaculty(profB);

        uni.showDepartments();
        uni.showFaculties();

        // Faculty can exist independently
        Faculty profC = new Faculty("Prof. Carol");
        System.out.println("Independent Faculty: " + profC.getName());

        // Deleting university deletes departments
        uni.deleteUniversity();
        uni.showDepartments();
    }
}