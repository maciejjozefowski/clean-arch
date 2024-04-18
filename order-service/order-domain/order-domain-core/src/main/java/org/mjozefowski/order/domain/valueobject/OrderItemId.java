package org.mjozefowski.order.domain.valueobject;

import org.mjozefowski.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
