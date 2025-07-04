import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();
    private double subTotal = 0;
    private final double SHIPPING_RATE = 2.5;

    public List<Product> getProducts() {
        return products;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void addProduct(Product product, int quantity) {
        if (!product.checkQuantity(quantity)) {
            if (product.getQuantity() == 0)
                System.out.println("Product : " + product.getName() + " is out of stock");
            else
                System.out.println("Maximum available quantity of Product : " + product.getName() + " = " + product.getQuantity());
            return;
        }

        if (isExpired(product)) {
            System.out.println("Cannot add expired product: " + product.getName());
            return;
        }

        products.add(product);
        product.reduceQuantity(quantity);
        subTotal += (product.getPrice() * quantity);
        System.out.println("Added " + quantity + " of " + product.getName());
    }

    private boolean isExpired(Product product) {
        if (product instanceof Expirable) {
            return ((Expirable) product).isExpired();
        }
        return false;
    }

    public double calculateTotalWeight() {
        return products.stream()
                .filter(p -> p instanceof Shippable)
                .mapToDouble(p -> ((Shippable) p).getWeight())
                .sum()*SHIPPING_RATE;
    }

    public double calculateSubTotal() {
        return subTotal;
    }

    public double calculateTotalPrice() {
        return subTotal + calculateTotalWeight();
    }






}