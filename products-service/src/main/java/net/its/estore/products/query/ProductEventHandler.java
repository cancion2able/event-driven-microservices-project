package net.its.estore.products.query;

import lombok.RequiredArgsConstructor;
import net.its.estore.products.core.data.ProductEntity;
import net.its.estore.products.core.data.ProductRepository;
import net.its.estore.products.core.event.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product-group")
public class ProductEventHandler {

    private final ProductRepository repository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        final ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        repository.save(productEntity);
    }
}
