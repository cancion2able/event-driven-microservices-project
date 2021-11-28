package net.its.estore.products.query;

import lombok.RequiredArgsConstructor;
import net.its.estore.core.event.ProductReservedEvent;
import net.its.estore.products.core.data.ProductEntity;
import net.its.estore.products.core.data.ProductRepository;
import net.its.estore.products.core.event.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product-group")
public class ProductEventHandler {

    private final ProductRepository repository;

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    public void handle(IllegalArgumentException exception) {
        // Log error message
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        final ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        try {
            repository.save(productEntity);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @EventHandler
    public void on(ProductReservedEvent event) {
        final ProductEntity product = repository.findByProductId(event.getProductId());
        product.setQuantity(product.getQuantity() - event.getQuantity());
        repository.save(product);
    }
}
