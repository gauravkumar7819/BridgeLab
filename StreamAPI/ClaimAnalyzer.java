package StreamAPI;

import java.util.*;
import static java.util.stream.Collectors.*;

public class ClaimAnalyzer {
    static class Claim {
        private String type;
        private double amount;

        public Claim(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        // Getters
        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        // Optional: toString for debugging
        @Override
        public String toString() {
            return "Claim{type='" + type + "', amount=" + amount + "}";
        }
    }

    public Map<String, Double> analyzeAverageClaimsByType(List<Claim> claims) {
        return claims.stream()
            .collect(groupingBy(
                Claim::getType,
                averagingDouble(Claim::getAmount)
            ));
    }

    // Example usage
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Health", 7000),
            new Claim("Auto", 15000),
            new Claim("Auto", 10000),
            new Claim("Life", 20000)
        );

        ClaimAnalyzer analyzer = new ClaimAnalyzer();
        Map<String, Double> avgClaims = analyzer.analyzeAverageClaimsByType(claims);

        avgClaims.forEach((type, avg) -> 
            System.out.println(type + " => " + avg)
        );
    }
}
