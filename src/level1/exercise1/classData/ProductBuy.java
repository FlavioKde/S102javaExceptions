package level1.exercise1.classData;

import level1.exercise1.exceptions.EmptySaleException;

import java.util.ArrayList;



public class ProductBuy {
    private ArrayList<Product> products;
    private double totalPrice;

    public ProductBuy(double totalPrice) {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotal(double totalPrice) throws EmptySaleException {

        if (products.isEmpty()) {
            throw new EmptySaleException("To make a sale, you first have to add products");
        }

        double total = 0.0;


        for (Product product : products) {
            total += product.getPrice();
        }

        return total;



    }

    @Override
    public String toString() {
        return "ProductBuy: " +"\n"+
                "products= " + products +"\n"+
                "totalPrice=" + totalPrice
                ;
    }
}
