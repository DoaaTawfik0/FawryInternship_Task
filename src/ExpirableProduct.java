import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable{

    private final LocalDate expirationDate;

    public ExpirableProduct(Product product, LocalDate expirationDate) {
        super(product.getName(), product.getQuantity(), product.getPrice());
        this.expirationDate = expirationDate;
        product.setExpirable(true);
    }

    @Override
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
