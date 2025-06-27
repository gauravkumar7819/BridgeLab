import java.util.*;

class Product {
    private String name;
    public Product(String name) { this.name = name; }
    public String getName() { return name; }
}

class Customer {
    private String name;
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
    public Order placeOrder(List<Product> products) {
        Order order = new Order(this, products);
        System.out.println(name + " placed an order.");
        return order;
    }
}

class Order {
    private Customer customer;
    private List<Product> products;
    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = new ArrayList<>(products);
    }
    public void showOrderDetails() {
        System.out.println("Order by: " + customer.getName());
        System.out.println("Products:");
        for (Product p : products) System.out.println("- " + p.getName());
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice");
        Product p1 = new Product("Laptop");
        Product p2 = new Product("Mouse");
        List<Product> products = Arrays.asList(p1, p2);

        Order order = alice.placeOrder(products);
        order.showOrderDetails();
    }
}