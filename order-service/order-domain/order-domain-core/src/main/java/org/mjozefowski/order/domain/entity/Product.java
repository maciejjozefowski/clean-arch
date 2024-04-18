package org.mjozefowski.order.domain.entity;

import org.mjozefowski.domain.entity.BaseEntity;
import org.mjozefowski.domain.valueobject.Money;
import org.mjozefowski.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId id) {
        super.setId(id);
    }

    public Product(ProductId id, String name, Money price) {
        super.setId(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
