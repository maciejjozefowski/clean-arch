package org.mjozefowski.domain.event.publisher;

import org.mjozefowski.domain.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {
    void publish(T event);
}
