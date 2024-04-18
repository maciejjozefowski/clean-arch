package org.mjozefowski.order.domain;

import org.mjozefowski.order.domain.entity.Order;
import org.mjozefowski.order.domain.entity.Restaurant;
import org.mjozefowski.order.domain.event.OrderCancelledEvent;
import org.mjozefowski.order.domain.event.OrderCreatedEvent;
import org.mjozefowski.order.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);
}
