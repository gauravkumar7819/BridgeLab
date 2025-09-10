package interfaces;

public interface DigitalPayment {
    boolean pay(double amount);
}

class UPIPayment implements DigitalPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment: $" + amount);
        return true;
    }
}

class CreditCardPayment implements DigitalPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing Credit Card payment: $" + amount);
        return true;
    }
}

class WalletPayment implements DigitalPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing Wallet payment: $" + amount);
        return true;
    }
}