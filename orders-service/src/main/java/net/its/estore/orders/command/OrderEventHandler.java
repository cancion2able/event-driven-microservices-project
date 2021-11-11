package net.its.estore.orders.command;

import lombok.RequiredArgsConstructor;
import net.its.estore.orders.core.data.OrderEntity;
import net.its.estore.orders.core.data.OrderRepository;
import net.its.estore.orders.core.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventHandler {

    private final OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent orderCreatedEvent) {
        final OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderCreatedEvent, orderEntity);
        orderRepository.save(orderEntity);
    }




}
