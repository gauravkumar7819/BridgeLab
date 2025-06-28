import java.util.*;

public class EasyFlightBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Flights stored in arrays
        String[] flightNumbers = {"F101", "F102", "F103"};
        String[] fromCities = {"Delhi", "Delhi", "Mumbai"};
        String[] toCities = {"Mumbai", "Chennai", "Kolkata"};

        // Bookings stored in lists
        ArrayList<String> passengerNames = new ArrayList<>();
        ArrayList<String> bookedFlights = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Show All Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Show Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.println("\nAvailable Flights:");
                for (int i = 0; i < flightNumbers.length; i++) {
                    System.out.println("Flight: " + flightNumbers[i] + " | From: " + fromCities[i] + " | To: " + toCities[i]);
                }

            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter flight number to book: ");
                String fNo = sc.nextLine();

                boolean found = false;
                for (String flight : flightNumbers) {
                    if (flight.equalsIgnoreCase(fNo)) {
                        passengerNames.add(name);
                        bookedFlights.add(fNo);
                        System.out.println("Booking done successfully!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Flight not found.");
                }

            } else if (choice == 3) {
                System.out.println("\nAll Bookings:");
                if (passengerNames.size() == 0) {
                    System.out.println("No bookings found.");
                } else {
                    for (int i = 0; i < passengerNames.size(); i++) {
                        System.out.println("Name: " + passengerNames.get(i) + ", Flight: " + bookedFlights.get(i));
                    }
                }

            } else if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

    }
}
