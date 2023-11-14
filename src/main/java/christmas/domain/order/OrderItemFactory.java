package christmas.domain.order;

import static christmas.utils.ConstantUtils.ORDER_ERROR_PREFIX;

import christmas.domain.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class OrderItemFactory {

    public static Map<MenuItem, Integer> convertToMenuItems(Map<String, Integer> orderDetails) {
        Map<MenuItem, Integer> orderItems = new HashMap<>();
        for (Map.Entry<String, Integer> entry : orderDetails.entrySet()) {
            MenuItem menuItem = MenuItem.findMenu(entry.getKey());
            if (menuItem == null) {
	throw new IllegalArgumentException(
	    ORDER_ERROR_PREFIX + "메뉴 " + entry.getKey() + "는 존재 하지 않습니다.");
            }
            if (orderItems.containsKey(menuItem)) {
	throw new IllegalArgumentException(ORDER_ERROR_PREFIX + menuItem + "은 이미 주문했습니다.");
            }
            orderItems.put(menuItem, entry.getValue());
        }
        return orderItems;
    }
}
