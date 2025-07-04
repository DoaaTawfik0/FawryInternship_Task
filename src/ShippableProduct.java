public class ShippableProduct extends Product implements Shippable{
    private final double weight;

    public ShippableProduct(Product product, double weight) {
        super(product.getName(), product.getQuantity(), product.getPrice());
        this.weight = weight;
        product.setShippable(true);
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
