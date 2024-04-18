package org.mjozefowski.order.service.domain.ports.output.repository;

import org.mjozefowski.order.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
