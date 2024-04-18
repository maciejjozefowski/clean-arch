package org.mjozefowski.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.mjozefowski.order.service.domain.dto.track.TrackOrderQuery;
import org.mjozefowski.order.service.domain.dto.track.TrackOrderResponse;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderTrackCommandHandler {
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return null;
    }

}
