package org.mjozefowski.order.service.domain.ports.output.repository;

import org.mjozefowski.order.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);


}
