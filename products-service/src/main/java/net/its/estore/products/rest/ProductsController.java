package net.its.estore.products.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @PostMapping
    public String createProduct() {
        return "HTTP POST is handled";
    }

    @GetMapping
    public String getProduct() {
        return "HTTP GET is handled";
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
