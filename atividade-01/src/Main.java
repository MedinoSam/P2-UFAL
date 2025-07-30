import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        double price;
        int quantity;
        int value;

        System.out.println("Enter product data:");
        System.out.printf("Name:");
        name = sc.next();
        System.out.printf("Price:");
        price = sc.nextDouble();
        System.out.printf("Quantity:");
        quantity = sc.nextInt();

        Product product = new Product(name, quantity, price);
        System.out.println("Product data: " + product.toString());

        System.out.println("Enter the number of products to be added in stock: ");
        value = sc.nextInt();
        product.addProducts(value);
        System.out.println("Updated data: " + product.toString());

        System.out.println("Enter the number of products to be removed from stock: ");
        value = sc.nextInt();
        product.removeProducts(value);
        System.out.printf("Updated data: " + product.toString());

    }
}