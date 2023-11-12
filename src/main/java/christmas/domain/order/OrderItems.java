package christmas.domain.order;

import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderItems {

    private final Map<MenuItem, Integer> orderItems;

    private OrderItems(Map<MenuItem, Integer> convertedItems) {
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
            if (menuItem != null) {
                orderItems.put(menuItem, entry.getValue());
            } else {
                throw new IllegalArgumentException("메뉴 " + entry.getKey() + "는 존재하지 않습니다.");
            }
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
}