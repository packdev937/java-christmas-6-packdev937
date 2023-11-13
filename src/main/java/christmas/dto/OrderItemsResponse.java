package christmas.dto;

import christmas.domain.menu.MenuItem;
import java.util.Map;

public record OrderItemsResponse(Map<MenuItem, Integer> orderItems) {

    public OrderItemsResponse(Map<MenuItem, Integer> orderItems) {
        this.orderItems = orderItems;
    }
}