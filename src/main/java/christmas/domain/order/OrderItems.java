package christmas.domain.order;

import static christmas.utils.ConstantUtils.*;

import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.dto.OrderItemsResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderItems {

    private final Map<MenuItem, Integer> orderItems;

    private OrderItems(Map<MenuItem, Integer> orderItems) {
        OrderValidator.validateOrder(orderItems);
        this.orderItems = orderItems;
    }

    public static OrderItems from(Map<MenuItem, Integer> orderItems) {
        return new OrderItems(orderItems);
    }

    public Map<MenuItem, Integer> getItemsByType(MenuType type) {
        return orderItems.entrySet().stream()
            .filter(entry -> entry.getKey().getType() == type)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<MenuItem, Integer> getOrderItems() {
        return Collections.unmodifiableMap(orderItems);
    }

    public OrderItemsResponse toResponse() {
        return new OrderItemsResponse(orderItems);
    }
}