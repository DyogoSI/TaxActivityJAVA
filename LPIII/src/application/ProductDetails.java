package application;

import java.util.Scanner;

public class ProductDetails {
    private double productPrice;
    private double shippingCost;
    private double insuranceCost;

    public ProductDetails(double productPrice, double shippingCost, double insuranceCost) {
        this.productPrice = productPrice;
        this.shippingCost = shippingCost;
        this.insuranceCost = insuranceCost;
    }

    public double calculateBasePrice() {
        return productPrice + shippingCost + insuranceCost;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
