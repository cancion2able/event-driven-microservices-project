package net.its.estore.products.rest;

import net.its.estore.products.command.CreateProductCommand;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Environment env;

    public ProductsController(Environment env) {
        this.env = env;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        final CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();
        return "HTTP POST is handled. " + createProductRestModel.getTitle();
    }

    @GetMapping
    public String getProduct() {
        return "HTTP GET is handled " + env.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "Http PUT is endbled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE is handled";
    }



}
