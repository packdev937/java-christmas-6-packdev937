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

    private OrderItems(Map<MenuItem, Integer> convertedItems) {
        OrderValidator.validateOrder(convertedItems);
        this.orderItems = convertedItems;
    }

    public static OrderItems from(Map<String, Integer> orderItems) {
        Map<MenuItem, Integer> convertedItems = convertToMenuItems(orderItems);
        return new OrderItems(convertedItems);
    }

    private static Map<MenuItem, Integer> convertToMenuItems(Map<String, Integer> orderDetails) {
        Map<MenuItem, Integer> orderItems = new HashMap<>();
        for (Map.Entry<String, Integer> entry : orderDetails.entrySet()) {
            MenuItem menuItem = MenuItem.findMenu(entry.getKey());
            if (menuItem == null) {
                throw new IllegalArgumentException(
                    ORDER_ERROR_PREFIX + "메뉴 " + entry.getKey() + "는 존재하지 않습니다.");
            }
            if (orderItems.containsKey(menuItem)) {
                throw new IllegalArgumentException(ORDER_ERROR_PREFIX + menuItem + "은 이미 주문했습니다.");
            }
            orderItems.put(menuItem, entry.getValue());
        }
        return orderItems;
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