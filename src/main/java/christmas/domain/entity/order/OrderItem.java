package christmas.domain.entity.order;

import christmas.domain.entity.menu.Item;
import java.util.HashMap;
import java.util.Map;

public class OrderItem {
    private Map<Item, Integer> orderItem = new HashMap<Item, Integer>();
}
