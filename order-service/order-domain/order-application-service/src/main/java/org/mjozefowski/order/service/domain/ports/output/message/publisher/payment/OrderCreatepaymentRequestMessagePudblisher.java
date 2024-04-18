package org.mjozefowski.order.service.domain.ports.output.message.publisher.payment;

import org.mjozefowski.domain.event.publisher.DomainEventPublisher;
import org.mjozefowski.order.domain.event.OrderCancelledEvent;

public interface OrderCreatepaymentRequestMessagePudblisher extends DomainEventPublisher<OrderCancelledEvent> {

}
