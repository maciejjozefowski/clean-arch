package org.mjozefowski.order.domain.entity;

import org.mjozefowski.domain.entity.BaseEntity;
import org.mjozefowski.domain.valueobject.Money;
import org.mjozefowski.domain.valueobject.OrderId;
import org.mjozefowski.order.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {

    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subtotal;

    private OrderItem(Builder builder) {
        orderId = builder.orderId;
        product = builder.product;
        quantity = builder.quantity;
        price = builder.price;
        subtotal = builder.subtotal;
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subtotal);
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        setId(orderItemId);
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubtotal() {
        return subtotal;
    }

    public static final class Builder {

        private OrderId orderId;
        private Product product;
        private int quantity;
        private Money price;
        private Money subtotal;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder subtotal(Money val) {
            subtotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
