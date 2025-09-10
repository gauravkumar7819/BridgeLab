package StreamAPI;

import java.time.*;
import java.util.*;

public class MembershipManager {
    static class Member {
        private String name;
        private LocalDate expiryDate;

        public Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        public String getName() {
            return name;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        @Override
        public String toString() {
            return "Member{name='" + name + "', expiryDate=" + expiryDate + "}";
        }
    }

    public List<Member> getExpiringMemberships(List<Member> members) {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        return members.stream()
            .filter(member -> member.getExpiryDate().isBefore(thirtyDaysFromNow))
            .toList(); // if using Java 16+, else use .collect(Collectors.toList())
    }

    // Example usage
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),   // expiring soon
            new Member("Sneha", LocalDate.now().plusDays(40)), // not expiring
            new Member("Raj", LocalDate.now().plusDays(25)),   // expiring soon
            new Member("Priya", LocalDate.now().plusDays(90))  // not expiring
        );

        MembershipManager manager = new MembershipManager();
        List<Member> expiring = manager.getExpiringMemberships(members);

        System.out.println("Expiring within 30 days:");
        expiring.forEach(System.out::println);
    }
}
