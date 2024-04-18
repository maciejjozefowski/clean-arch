package org.mjozefowski.order.service.domain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;
@Getter
@AllArgsConstructor
@Builder
public class TrackOrderQuery {
    @NotNull
    private UUID orderTrackingId;
}
