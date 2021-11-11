package net.its.estore.orders.command.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateOrderRestModel {

    @NotBlank(message = "Product id cannot be blank")
    private final String productId;
    @Min(value = 1, message = "Quantity cannot be less than 1")
    @Max(value = 5, message = "Quantity cannot be more than 5")
    private final int quantity;
    @NotBlank(message = "Address id cannot be blank")
    private final String addressId;
}
