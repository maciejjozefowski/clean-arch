package org.mjozefowski.order.service.domain.ports.output.repository;

import org.mjozefowski.order.domain.entity.Order;
import org.mjozefowski.order.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
