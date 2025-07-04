import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Expirable,Shippable
{
    private final Shippable product;
    private final LocalDate expirationDate;

    public ExpirableShippableProduct(Product product, LocalDate expirationDate) {
        super(product.getName(), product.getQuantity(), product.getPrice());
        this.expirationDate = expirationDate;
        this.product = (Shippable) product;
        product.setExpirable(true);
        product.setShippable(true);
    }

    @Override
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public double getWeight() {
        return product.getWeight();
    }
}
