package StreamAPI;

import java.util.*;

public class HospitalSystem {
    static class Doctor {
        private String name;
        private String specialty;
        private boolean availableOnWeekends;

        public Doctor(String name, String specialty, boolean availableOnWeekends) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekends = availableOnWeekends;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public boolean isAvailableOnWeekends() {
            return availableOnWeekends;
        }

        // Optional: toString for printing
        @Override
        public String toString() {
            return "Doctor{name='" + name + "', specialty='" + specialty +
                   "', availableOnWeekends=" + availableOnWeekends + "}";
        }
    }

    public List<Doctor> getWeekendDoctors(List<Doctor> doctors) {
        return doctors.stream()
            .filter(Doctor::isAvailableOnWeekends)
            .sorted(Comparator.comparing(Doctor::getSpecialty))
            .toList(); // If using Java 16+
            // .collect(Collectors.toList()); // If using Java 8–15
    }

    // Example main method
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Neurology", false),
            new Doctor("Dr. Gupta", "Orthopedics", true),
            new Doctor("Dr. Singh", "Dermatology", true)
        );

        HospitalSystem system = new HospitalSystem();
        List<Doctor> weekendDoctors = system.getWeekendDoctors(doctors);
        weekendDoctors.forEach(System.out::println);
    }
}
