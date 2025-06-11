public class ProfitCalculator {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit * 100.0) / costPrice;
        System.out.printf("""
            The Cost Price is INR %d and Selling Price is INR %d
            The Profit is INR %d and the Profit Percentage is %.2f%%
            """, costPrice, sellingPrice, profit, profitPercentage);
    }
}