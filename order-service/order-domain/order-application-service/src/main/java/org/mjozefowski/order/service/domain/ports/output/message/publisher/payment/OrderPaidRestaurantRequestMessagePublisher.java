package org.mjozefowski.order.service.domain.ports.output.message.publisher.payment;

import org.mjozefowski.domain.event.publisher.DomainEventPublisher;
import org.mjozefowski.order.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
