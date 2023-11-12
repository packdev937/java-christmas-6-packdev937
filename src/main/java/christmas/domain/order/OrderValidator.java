package christmas.domain.order;

import static christmas.utils.ConstantUtils.*;

import christmas.domain.menu.MenuType;
import christmas.domain.menu.MenuItem;
import java.util.Map;

public class OrderValidator {

    private static final int MINIMUM_ORDER_QUANTITY = 1;
    private static final int MAXIMUM_ITEMS_PER_ORDER = 20;

    public static void validateOrder(Map<MenuItem, Integer> items) {
        validateMinimumOrderQuantity(items);
        validateBeverageOnly(items);
        validateMaximumItems(items);
    }

    private static void validateMinimumOrderQuantity(Map<MenuItem, Integer> items) {
        int totalQuantity = items.values().stream().mapToInt(Integer::intValue).sum();
        if (totalQuantity < MINIMUM_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ORDER_ERROR_PREFIX + "적어도 한 개 이상의 메뉴를 주문해야 합니다.");
        }
    }


    private static void validateBeverageOnly(Map<MenuItem, Integer> items) {
        boolean isBeverageOnly = items.keySet().stream()
            .allMatch(item -> item.getType() == MenuType.BEVERAGE);
        if (isBeverageOnly && !items.isEmpty()) {
            throw new IllegalArgumentException(ORDER_ERROR_PREFIX + "음료만 주문할 수 없습니다.");
        }
    }

    private static void validateMaximumItems(Map<MenuItem, Integer> items) {
        int totalItems = items.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        if (totalItems > MAXIMUM_ITEMS_PER_ORDER) {
            throw new IllegalArgumentException(
                ORDER_ERROR_PREFIX + "메뉴는 한 번에 최대 " + MAXIMUM_ITEMS_PER_ORDER + "개까지만 주문할 수 있습니다.");
        }
    }
}
