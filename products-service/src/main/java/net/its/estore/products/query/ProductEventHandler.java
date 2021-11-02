package net.its.estore.products.query;

import net.its.estore.products.core.event.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    @EventHandler
    public void on(ProductCreatedEvent event) {

    }
}
