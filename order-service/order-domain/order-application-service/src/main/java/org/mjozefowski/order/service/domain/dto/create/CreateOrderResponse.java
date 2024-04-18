package org.mjozefowski.order.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.mjozefowski.domain.valueobject.OrderStatus;
import org.mjozefowski.order.domain.valueobject.TrackingId;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;
    @NotNull
    private TrackingId orderTrackingId;
}
