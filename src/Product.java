public abstract class Product {
    private final String name;
    private int quantity;
    private int order;
    private final double price;
    private boolean shippable;
    private boolean expirable;


    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getOrder() {
        return order;
    }

    public boolean isShippable() {
        return shippable;
    }

    public boolean isExpirable() {
        return expirable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public void setExpirable(boolean expirable) {
        this.expirable = expirable;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // Business methods
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
        this.order += quantity;
    }

    public boolean checkQuantity(int quantity) {
        return this.quantity >= quantity;
    }
}