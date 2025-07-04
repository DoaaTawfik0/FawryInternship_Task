public interface Shippable {
    double getWeight();
    String getName();
    default boolean isShippable() { return true;}
}