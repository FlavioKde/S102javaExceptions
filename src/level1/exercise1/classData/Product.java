package level1.exercise1.classData;

public class Product {
    private String name;
    private double price;

     public Product(String name, double price){
         this.name = name;
         this.price = price;
     }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + "\n"+
                "name= " + name + '\n' +
                "price= " + price
                ;
    }
}
