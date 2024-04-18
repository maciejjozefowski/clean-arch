package org.mjozefowski.order.service.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mjozefowski.order.domain.OrderDomainService;
import org.mjozefowski.order.domain.entity.Customer;
import org.mjozefowski.order.domain.entity.Order;
import org.mjozefowski.order.domain.entity.Restaurant;
import org.mjozefowski.order.domain.event.OrderCreatedEvent;
import org.mjozefowski.order.domain.exceptions.OrderDomainException;
import org.mjozefowski.order.service.domain.dto.create.CreateOrderCommand;
import org.mjozefowski.order.service.domain.dto.create.CreateOrderResponse;
import org.mjozefowski.order.service.domain.mapper.OrderDataMapper;
import org.mjozefowski.order.service.domain.ports.output.repository.CustomerRepository;
import org.mjozefowski.order.service.domain.ports.output.repository.OrderRepository;
import org.mjozefowski.order.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class OrderCreateCommandHandler {
    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    private final RestaurantRepository restaurantRepository;

    private final OrderDataMapper orderDataMapper;

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        orderDomainService.validateAndInitiateOrder(order, restaurant);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        Order orderResult = savedOrder(order);
        log.info("Order created with id {}", orderResult.getId().getValue());
        return orderDataMapper.orderToCreateOrderResponse(orderResult);
    }


    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findRestaurantInformation(restaurant);
        if (restaurantOptional.isEmpty()) {
            log.warn("Restaurant not found {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Restaurant not found");
        }
        return restaurantOptional.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Customer not found {}", customerId);
            throw new OrderDomainException("Customer not found");
        }
    }

    private Order savedOrder(Order order) {
        Order orderResult =  orderRepository.save(order);
        if (orderResult == null) {
            log.error("Order not saved {}", order);
            throw new OrderDomainException("Order not saved");
        }
        log.info("Order saved {}", orderResult);
        return orderResult;
    }


}
