package christmas.domain.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OrderItems 클래스")
public class OrderItemsTest {

    private OrderItems orderItems;

    @BeforeEach
    public void setUp() {
        Map<String, Integer> order = new HashMap<>();
        order.put("바비큐립", 2);
        order.put("티본스테이크", 1);
        order.put("아이스크림", 3);
        orderItems = OrderItems.from(order);
    }

    @Test
    public void MenuType에_따라_MenuItem을_가져온다() {
        Map<MenuItem, Integer> result = orderItems.getItemsByType(MenuType.MAIN);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(MenuItem.BBQ_RIBS));
        assertTrue(result.containsKey(MenuItem.T_BONE_STEAK));
    }

    @Test
    public void 해당하는_MenuType이_없다면_빈_값이다() {
        Map<MenuItem, Integer> result = orderItems.getItemsByType(MenuType.APPETIZER);
        assertTrue(result.isEmpty());
    }

    @Test
    public void 반환받은_OrderItmes은_항상_동일하다() {
        Map<MenuItem, Integer> newOrderItems = orderItems.getOrderItems();

        assertNotNull(newOrderItems);
        assertEquals(3, newOrderItems.size());
        assertTrue(newOrderItems.containsKey(MenuItem.BBQ_RIBS));
        assertTrue(newOrderItems.containsKey(MenuItem.T_BONE_STEAK));
    }
}