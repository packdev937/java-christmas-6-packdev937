package christmas.domain.order;

import christmas.domain.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("OrderItemFactory 클래ㅇ")
class OrderItemFactoryTest {

    private OrderItemFactory orderItemFactory;

    @BeforeEach
    void setUp() {
        orderItemFactory = new OrderItemFactory();
    }

    @Test
    void 유효한_주문_상세_정보로_convertToMenuItems_메소드를_테스트한다() {
        Map<String, Integer> orderDetails = new HashMap<>();
        orderDetails.put("양송이수프", 2);
        orderDetails.put("타파스", 1);

        Map<MenuItem, Integer> menuItems = orderItemFactory.convertToMenuItems(orderDetails);

        assertThat(menuItems).contains(
            entry(MenuItem.MUSHROOM_SOUP, 2),
            entry(MenuItem.TAPAS, 1)
        );
    }

    @Test
    void 유효하지_않은_메뉴_항목이_포함된_경우_예외를_발생다다() {
        Map<String, Integer> orderDetails = new HashMap<>();
        orderDetails.put("InvalidMenuItem", 1);

        assertThrows(IllegalArgumentException.class,
            () -> orderItemFactory.convertToMenuItems(orderDetails));
    }
}
