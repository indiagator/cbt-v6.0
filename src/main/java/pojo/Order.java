package pojo;

import java.util.Set;

public class Order {
    private final String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    private Set<Product> productSet;
    private int orderPrice;
}
