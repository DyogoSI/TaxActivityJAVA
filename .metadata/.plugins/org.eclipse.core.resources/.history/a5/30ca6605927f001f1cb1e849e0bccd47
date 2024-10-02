package application;

public class TaxManager {
    private double ipiRate = 0.15 / 100; 
    private double icmsRate;  
    private double issRate;   

    public TaxManager(double icmsRate, double issRate) {
        this.icmsRate = icmsRate;
        this.issRate = issRate;
    }

    public double calculateIPI(ProductDetails product) {
        return product.calculateBasePrice() * ipiRate;
    }

    public double calculateICMS(ProductDetails product) {
        return product.getProductPrice() * (icmsRate / 100);
    }

    public double calculateISS(double servicePrice) {
        return servicePrice * (issRate / 100);
    }
}
