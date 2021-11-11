package net.its.estore.orders.core.data;

import lombok.Data;
import net.its.estore.orders.core.model.OrderStatus;

import javax.persistence.*;

@Data
@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @Column(unique = true)
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
