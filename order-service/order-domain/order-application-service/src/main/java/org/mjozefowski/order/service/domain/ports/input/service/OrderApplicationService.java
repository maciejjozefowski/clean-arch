package org.mjozefowski.order.service.domain.ports.input.service;

import org.mjozefowski.order.service.domain.dto.create.CreateOrderCommand;
import org.mjozefowski.order.service.domain.dto.create.CreateOrderResponse;
import org.mjozefowski.order.service.domain.dto.track.TrackOrderQuery;
import org.mjozefowski.order.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
