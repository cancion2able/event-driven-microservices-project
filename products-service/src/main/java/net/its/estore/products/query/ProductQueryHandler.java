package net.its.estore.products.query;

import net.its.estore.products.core.data.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductQueryHandler {

    private final ProductRepository repository;

    public ProductQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }


}
