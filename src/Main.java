import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /*creating Cart*/
        Cart cart = new Cart();

        /*creating customer*/
        Customer customer = new Customer("Doaa", 3000, cart);

        /*Adding Products*/
        // Simple product
        Product notebook = new SimpleProduct("Notebook", 4, 2);

        // Expirable product
        Product milk = new ExpirableProduct(
                new SimpleProduct("Milk", 5, 1),
                LocalDate.now().plusDays(7)
        );

        // Shippable product
        Product book = new ShippableProduct(
                new SimpleProduct("Textbook", 3, 50),
                1.5
        );

        // Shippable && Expirable product
        Product electronics = new ExpirableShippableProduct(
                new ShippableProduct(
                        new SimpleProduct("Smartphone", 4, 690), 0.3),
                LocalDate.now().plusDays(1)
        );

        // Expired product
        Product expiredBread = new ExpirableProduct(
                new SimpleProduct("Bread", 3, 2),
                LocalDate.now().minusDays(1)
        );

        /*First Order*/
        cart.addProduct(notebook, 3);
        cart.addProduct(milk, 3);
        cart.addProduct(book, 3);
        cart.addProduct(electronics, 3);
        cart.addProduct(expiredBread, 3);
        customer.doCheckout();

        /*Second Order*/
        cart.addProduct(notebook, 1);
        customer.doCheckout();

    }


}