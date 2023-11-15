package christmas.domain.order;

import static christmas.utils.ConstantUtils.ORDER_ERROR_PREFIX;
import static christmas.utils.ConstantUtils.RETRY_INPUT_MESSAGE;

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
	    ORDER_ERROR_PREFIX + "메뉴 " + entry.getKey() + "는 존재 하지 않습니다. "
	        + RETRY_INPUT_MESSAGE);
            }
            orderItems.put(menuItem, entry.getValue());
        }
        return orderItems;
    }
}
