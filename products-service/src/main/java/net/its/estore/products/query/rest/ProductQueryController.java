package net.its.estore.products.query.rest;

import lombok.RequiredArgsConstructor;
import net.its.estore.products.query.FindProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getProducts() {
        final FindProductsQuery findProductsQuery = new FindProductsQuery();
        return queryGateway
                .query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
    }
}
