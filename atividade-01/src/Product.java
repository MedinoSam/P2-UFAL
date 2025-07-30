import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    public double totalValueInStock() {
        double price = this.price;
        int quantity = this.quantity;
        return price * quantity;
    }
    @Override
    public String toString() {
        return
                name +", "+
                 "$ " + price +
                ", " + quantity +
                " units, " +
                "Total: $ " + this.totalValueInStock();
    }
}
