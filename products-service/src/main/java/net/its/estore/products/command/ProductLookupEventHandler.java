package net.its.estore.products.command;

import lombok.RequiredArgsConstructor;
import net.its.estore.products.core.data.ProductLookupEntity;
import net.its.estore.products.core.data.ProductLookupRepository;
import net.its.estore.products.core.event.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {

    private final ProductLookupRepository repository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        final ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(), event.getTitle());
        repository.save(productLookupEntity);
    }
}
