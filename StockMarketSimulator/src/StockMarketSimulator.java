import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Stock { // Constructor for creating Stock objects
    private String symbol;
    private String name;
    private double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() { // Getter method for retrieving the stock symbol
        return symbol;
    }

    public String getName() { // Getter method for retrieving the stock name
        return name;
    }

    public double getPrice() { // Getter method for retrieving the stock price
        return price;
    }

    @Override   // Override of the toString method to display stock information
    
    public String toString() {
        return symbol + " - " + name + " - $" + price;
    }
}

class Portfolio {    // Method for buying stocks and updating the portfolio

    private Map<String, Integer> stocks = new HashMap<>();

    public void buyStock(String symbol, int quantity) {
        stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity) {    // Method for selling stocks and updating the portfolio

        if (stocks.containsKey(symbol)) {
            int currentQuantity = stocks.get(symbol);
            if (quantity <= currentQuantity) {
                stocks.put(symbol, currentQuantity - quantity);
            } else {
                System.out.println("\n==============================================\n\n");
                System.out.println("You don't have enough shares of " + symbol + " to sell.");
                System.out.println("\n\n==============================================\n");
            }
        } else {
            System.out.println("\n==============================================\n\n");
            System.out.println("You don't own any shares of " + symbol + ".");
            System.out.println("\n\n==============================================\n");
        }
    }

    public void displayPortfolio() {    // Method for displaying the user's portfolio

        if (stocks.isEmpty()) {
            System.out.println("\n==============================================\n\n");
            System.out.println("Your portfolio is empty.");
            System.out.println("\n\n==============================================\n");
        } else {
            System.out.println("\n==============================================\n\n");
            System.out.println("Portfolio:");
            for (String symbol : stocks.keySet()) {
                int quantity = stocks.get(symbol);
                System.out.println(symbol + " - " + quantity + " shares");
            }System.out.println("\n\n==============================================\n");
        }
    }
}

public class StockMarketSimulator {
    public static void main(String[] args) {
        List<Stock> availableStocks = new ArrayList<>();
        availableStocks.add(new Stock("AAPL", "Apple Inc.", 150.0));
        availableStocks.add(new Stock("GOOGL", "Alphabet Inc.", 2700.0));
        availableStocks.add(new Stock("TSLA", "Tesla, Inc.", 800.0));

        Portfolio portfolio = new Portfolio();
        Scanner scanner = new Scanner(System.in);

        while (true) {        // Code for initializing available stocks, creating a Portfolio object, and handling user input

            System.out.println("\nAvailable Stocks:");
            for (Stock stock : availableStocks) {
                System.out.println(stock);
            }
            
            // Display menu options
            System.out.println("\n\n==============================================\n");
            System.out.println("\n1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Display Portfolio");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();            // Read user's choice

            System.out.println("\n\n==============================================\n");

            switch (choice) {            // Handle user's choice with appropriate method calls

                case 1:                    // Code for buying stocks

                    System.out.print("Enter the stock symbol to buy: ");
                    String buySymbol = scanner.next();
                    System.out.print("Enter the quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    portfolio.buyStock(buySymbol, buyQuantity);
                    break;
                case 2:                    // Code for selling stocks

                    System.out.print("Enter the stock symbol to sell: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter the quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    portfolio.sellStock(sellSymbol, sellQuantity);
                    break;
                case 3:                    // Code for displaying the portfolio

                    portfolio.displayPortfolio();
                    break;
                case 4:                    // Code for quitting the program

                    
                    System.out.println("\n\n==============================================\n\n");
                    System.out.println("Goodbye!");
                    System.out.println("\n\n==============================================\n\n");
                    scanner.close();
                    System.exit(0);
                default:
                    
                    System.out.println("\n\n==============================================\n\n");
                    System.out.println("Invalid choice. Please try again.");
                    
                    System.out.println("\n\n==============================================\n");
            }
        }
    }
}
