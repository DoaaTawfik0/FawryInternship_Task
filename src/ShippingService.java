import java.util.List;

public class ShippingService {
    public void shipItems(List<Shippable> items) {
        System.out.println("--------------------------------------");
        System.out.println("   ** Shippable Items   ** ");

        items.forEach(item ->
                System.out.println("Shipping: " + item.getName() + " (Weight: " + item.getWeight() + ")"));
    }
}