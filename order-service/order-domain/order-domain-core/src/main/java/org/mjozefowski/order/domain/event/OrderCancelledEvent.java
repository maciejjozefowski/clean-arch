package org.mjozefowski.order.domain.event;

import org.mjozefowski.domain.event.DomainEvent;
import org.mjozefowski.order.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }

}
