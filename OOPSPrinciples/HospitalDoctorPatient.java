import java.util.*;

class Patient {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    public Patient(String name) { this.name = name; }
    public String getName() { return name; }
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) doctors.add(doctor);
    }
    public void showDoctors() {
        System.out.println(name + " consulted:");
        for (Doctor d : doctors) System.out.println("- " + d.getName());
    }
}

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();
    public Doctor(String name) { this.name = name; }
    public String getName() { return name; }
    public void consult(Patient patient) {
        if (!patients.contains(patient)) patients.add(patient);
        patient.addDoctor(this);
        System.out.println("Dr. " + name + " consulted " + patient.getName());
    }
    public void showPatients() {
        System.out.println("Dr. " + name + " has patients:");
        for (Patient p : patients) System.out.println("- " + p.getName());
    }
}

class Hospital {
    private String name;
    public Hospital(String name) { this.name = name; }
}

public class HospitalDoctorPatient {
    public static void main(String[] args) {
        Doctor drA = new Doctor("Alice");
        Doctor drB = new Doctor("Bob");
        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Mary");

        drA.consult(p1);
        drA.consult(p2);
        drB.consult(p1);

        drA.showPatients();
        drB.showPatients();
        p1.showDoctors();
        p2.showDoctors();
    }
}