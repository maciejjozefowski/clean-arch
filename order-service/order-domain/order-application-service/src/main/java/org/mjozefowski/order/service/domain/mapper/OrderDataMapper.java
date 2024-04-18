package org.mjozefowski.order.service.domain.mapper;

import org.mjozefowski.domain.valueobject.CustomerId;
import org.mjozefowski.domain.valueobject.Money;
import org.mjozefowski.domain.valueobject.ProductId;
import org.mjozefowski.order.domain.entity.Order;
import org.mjozefowski.order.domain.entity.OrderItem;
import org.mjozefowski.order.domain.entity.Product;
import org.mjozefowski.order.domain.entity.Restaurant;
import org.mjozefowski.order.domain.valueobject.StreetAddress;
import org.mjozefowski.order.service.domain.dto.create.CreateOrderCommand;
import org.mjozefowski.order.service.domain.dto.create.CreateOrderResponse;
import org.mjozefowski.order.service.domain.dto.create.OrderAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.Builder.builder()
                .restaurantId(createOrderCommand.getRestaurantId().getValue())
                .products(createOrderCommand.getItems().stream()
                        .map(orderItem -> new Product(new ProductId(orderItem.getProductId())))
                        .toList())
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.Builder.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(createOrderCommand.getRestaurantId())
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrdreItemsEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderTrackingId(order.getTrackingId())
                .build();
    }

    private List<OrderItem> orderItemsToOrdreItemsEntities(List<org.mjozefowski.order.service.domain.dto.create.OrderItem> items) {
        return items.stream()
                .map(item ->
                        OrderItem.Builder.builder()
                                .product(new Product(new ProductId(item.getProductId())))
                                .price(new Money(item.getPrice()))
                                .quantity(item.getQuantity())
                                .subtotal(new Money(item.getSubTotal()))
                                .build()
                ).toList();
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
        return new StreetAddress(UUID.randomUUID(), address.getStreet(), address.getCity(), address.getPostalCode());
    }
}
