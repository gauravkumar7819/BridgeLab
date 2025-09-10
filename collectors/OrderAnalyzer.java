package collectors;

import java.util.*;
import static java.util.stream.Collectors.*;

public class OrderAnalyzer {
    static class Order {
        private String customerId;
        private double amount;

        public Order(String customerId, double amount) {
            this.customerId = customerId;
            this.amount = amount;
        }

        public String getCustomerId() { return customerId; }
        public double getAmount() { return amount; }
    }

    public Map<String, Double> calculateRevenuePerCustomer(List<Order> orders) {
        return orders.stream()
            .collect(groupingBy(
                Order::getCustomerId,
                summingDouble(Order::getAmount)
            ));
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("C1", 100.0),
            new Order("C2", 150.0),
            new Order("C1", 200.0)
        );

        OrderAnalyzer analyzer = new OrderAnalyzer();
        Map<String, Double> revenue = analyzer.calculateRevenuePerCustomer(orders);
        revenue.forEach((customer, total) -> 
            System.out.println("Customer " + customer + ": $" + total));
    }
}