package org.mjozefowski.order.domain.valueobject;

import org.mjozefowski.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
