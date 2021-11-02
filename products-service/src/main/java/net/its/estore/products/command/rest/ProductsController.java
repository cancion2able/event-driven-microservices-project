package net.its.estore.products.command.rest;

import net.its.estore.products.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Environment env;
    private final CommandGateway commandGateway;

    public ProductsController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        final CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();
        String returnValue;
        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception exception) {
            returnValue = exception.getLocalizedMessage();
        }
        return returnValue;
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
