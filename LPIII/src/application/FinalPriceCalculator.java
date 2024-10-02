package application;

import java.util.Scanner;

public class FinalPriceCalculator {
    private ProductDetails product;
    private TaxManager taxManager;
    private double profitMargin;

    public FinalPriceCalculator(ProductDetails product, TaxManager taxManager, double profitMargin) {
        this.product = product;
        this.taxManager = taxManager;
        this.profitMargin = profitMargin;
    }

    public double calculateProfit() {
        return product.getProductPrice() * (profitMargin / 100);
    }

    public double calculateFinalPrice() {
        double ipi = taxManager.calculateIPI(product);
        double icms = taxManager.calculateICMS(product);
        double profit = calculateProfit();
        return product.getProductPrice() + ipi + icms + profit;
    }

    public void showPriceDetails() {
        double ipi = taxManager.calculateIPI(product);
        double icms = taxManager.calculateICMS(product);
        double profit = calculateProfit();

        System.out.println("Product Base Price: R$ " + product.getProductPrice());
        System.out.println("IPI: R$ " + ipi);
        System.out.println("ICMS: R$ " + icms);
        System.out.println("Profit: R$ " + profit);
        System.out.println("Final Price: R$ " + calculateFinalPrice());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product price: R$ ");
        double productPrice = scanner.nextDouble();

        System.out.print("Enter shipping cost: R$ ");
        double shippingCost = scanner.nextDouble();

        System.out.print("Enter insurance cost: R$ ");
        double insuranceCost = scanner.nextDouble();

        System.out.print("Enter ICMS rate (in %): ");
        double icmsRate = scanner.nextDouble();

        System.out.print("Enter ISS rate (in %): ");
        double issRate = scanner.nextDouble();

        System.out.print("Enter profit margin (in %): ");
        double profitMargin = scanner.nextDouble();

        ProductDetails product = new ProductDetails(productPrice, shippingCost, insuranceCost);
        TaxManager taxManager = new TaxManager(icmsRate, issRate);
        FinalPriceCalculator calculator = new FinalPriceCalculator(product, taxManager, profitMargin);

        calculator.showPriceDetails();

        scanner.close();
    }
}