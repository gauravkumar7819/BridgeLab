import java.util.*;

class Patient {
    private String nam;
    private List<Doctor> doctors = new ArrayList<>();
    public Patient(String nam) { this.nam = nam; }
    public String getnam() { return nam; }
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) doctors.add(doctor);
    }
    public void showDoctors() {
        System.out.println(nam + " consulted:");
        for (Doctor d : doctors) System.out.println("- " + d.getnam());
    }
}
class Doctor {
    private String nam;
    private List<Patient> patients = new ArrayList<>();
    public Doctor(String nam) { this.nam = nam; }
    public String getnam() { return nam; }
    public void consult(Patient patient) {
        if (!patients.contains(patient)) patients.add(patient);
        patient.addDoctor(this);
        System.out.println("Dr. " + nam + " consulted " + patient.getnam());
    }
    public void showPatients() {
        System.out.println("Dr. " + nam + " has patients:");
        for (Patient p : patients) System.out.println("- " + p.getnam());
    }
}

class Hospital {
    private String nam;
    public Hospital(String nam) { this.nam = nam; }
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