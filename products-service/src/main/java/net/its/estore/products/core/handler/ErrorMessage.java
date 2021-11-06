package net.its.estore.products.core.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final Date timestamp;
    private final String message;
}
