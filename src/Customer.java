import java.util.List;

public class Customer {
    private String name;
    private double balance;

    private Cart cart;

    public Customer(String name, double balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }

    public void doCheckout() {
        if (!cart.getProducts().isEmpty()) {
            if (checkBalance()) {
                List<Shippable> shippableItems = cart.getProducts().stream()
                        .filter(p -> p instanceof Shippable)
                        .map(p -> (Shippable) p)
                        .toList();
                new ShippingService().shipItems(shippableItems);

                System.out.println("   ---------------------   ");
                System.out.println("   ** Shipment notice **   ");

                for (Product product : cart.getProducts()) {
                    System.out.println("Product: " + product.getName()
                            + "    ||   Quantity: " + product.getOrder()
                            + "    ||   Price: " + (product.getOrder() * product.getPrice()));
                    product.setOrder(0); // reset order of each element
                }

                System.out.println("   ---------------------   ");
                System.out.println("Subtotal      " + cart.calculateSubTotal());
                System.out.println("Shipping      " + cart.calculateTotalWeight());
                System.out.println("Amount        " + cart.calculateTotalPrice());
                System.out.println("   ---------------------   ");

                balance -= cart.calculateTotalPrice(); // update balance
                cart.setSubTotal(0);
                cart.getProducts().clear(); // clear cart after checkout

            } else {
                throw new IllegalArgumentException("Customer's balance is insufficient..");
            }

        } else {
            throw new IllegalArgumentException("Cart is empty..");
        }

    }

    private boolean checkBalance() {
        return this.balance >= cart.calculateTotalPrice();
    }


}
