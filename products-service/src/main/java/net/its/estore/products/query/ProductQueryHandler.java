package net.its.estore.products.query;

import lombok.RequiredArgsConstructor;
import net.its.estore.products.core.data.ProductEntity;
import net.its.estore.products.core.data.ProductRepository;
import net.its.estore.products.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductQueryHandler {

    private final ProductRepository repository;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> productRestModels = new ArrayList<>();
        final List<ProductEntity> storedProducts = repository.findAll();
        for (ProductEntity storedProduct : storedProducts) {
            final ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(storedProduct, productRestModel);
            productRestModels.add(productRestModel);
        }
        return productRestModels;
    }

}
