package net.its.estore.products.rest;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Environment env;

    public ProductsController(Environment env) {
        this.env = env;
    }

    @PostMapping
    public String createProduct() {
        return "HTTP POST is handled";
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
