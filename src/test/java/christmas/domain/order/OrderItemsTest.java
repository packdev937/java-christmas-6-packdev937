package christmas.domain.order;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.dto.OrderItemsResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OrderItems 클래스")
public class OrderItemsTest {

    private OrderItems orderItems;

    @BeforeEach
    void setUp() {
        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.BBQ_RIBS, 2);
        order.put(MenuItem.T_BONE_STEAK, 1);
        order.put(MenuItem.ICE_CREAM, 3);
        orderItems = OrderItems.from(order);
    }

    @Test
    void MenuType에_따라_MenuItem을_가져온다() {
        Map<MenuItem, Integer> result = orderItems.getItemsByType(MenuType.MAIN);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(MenuItem.BBQ_RIBS));
        assertTrue(result.containsKey(MenuItem.T_BONE_STEAK));
    }

    @Test
    void 해당하는_MenuType이_없다면_빈_값을_반환한답() {
        Map<MenuItem, Integer> result = orderItems.getItemsByType(MenuType.APPETIZER);
        assertTrue(result.isEmpty());
    }

    @Test
    void 반환받은_OrderItems는_항상_동일하다() {
        Map<MenuItem, Integer> newOrderItems = orderItems.getOrderItems();

        assertNotNull(newOrderItems);
        assertEquals(3, newOrderItems.size());
        assertTrue(newOrderItems.containsKey(MenuItem.BBQ_RIBS));
        assertTrue(newOrderItems.containsKey(MenuItem.T_BONE_STEAK));
    }

    @Test
    void toResponse를_호출하면_올바른_OrderItemsResponse를_반환한다() {
        OrderItemsResponse response = orderItems.toResponse();

        assertNotNull(response);
        assertEquals(orderItems.getOrderItems(), response.orderItems());
    }

    @Test
    void 주문에_프로모션이_포함되어_있을_때_true를_반환한다() {
        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.BBQ_RIBS, 3);
        order.put(MenuItem.CHAMPAGNE, 1);
        OrderItems orderItemsWithPromotion = OrderItems.from(order);

        assertTrue(orderItemsWithPromotion.containPromotion());
    }

    @Test
    void 주문에_프로모션이_포함되어_있지_않을_때_false를_반환한다() {
        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.BBQ_RIBS, 3);
        OrderItems orderItemsWithoutPromotion = OrderItems.from(order);

        assertFalse(orderItemsWithoutPromotion.containPromotion());
    }

    @Test
    void 음료수만_주문할_때_예외를_발생한다() {
        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.CHAMPAGNE, 5);
        order.put(MenuItem.RED_WINE, 5);

        assertThrows(IllegalArgumentException.class, () -> OrderItems.from(order));
    }

    @Test
    void 아무것도_주문하지_않는다면_예외를_발생한다() {
        Map<MenuItem, Integer> order = new HashMap<>();

        assertThrows(IllegalArgumentException.class, () -> OrderItems.from(order));
    }

    @Test
    void 메뉴를_20개_이상_주문하면_예외를_발생한다() {
        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.BBQ_RIBS, 8);
        order.put(MenuItem.CHAMPAGNE, 8);
        order.put(MenuItem.RED_WINE, 7);

        assertThrows(IllegalArgumentException.class, () -> OrderItems.from(order));
    }
}