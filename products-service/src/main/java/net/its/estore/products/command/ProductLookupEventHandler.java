package net.its.estore.products.command;

import net.its.estore.products.core.event.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {

    @EventHandler
    public void on(ProductCreatedEvent event) {

    }
}
