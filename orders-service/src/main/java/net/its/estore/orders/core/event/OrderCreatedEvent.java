package net.its.estore.orders.core.event;

import lombok.Data;
import net.its.estore.orders.command.OrderStatus;

@Data
public class OrderCreatedEvent {

    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
