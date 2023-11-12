package christmas.domain.event;

import static christmas.domain.menu.MenuItem.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderItems;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TotalAmountTest {

    private TotalAmount totalAmount;
    private OrderItems orderItems;

    @BeforeEach
    public void setUp() {
        Map<String, Integer> order = new HashMap<>();
        order.put(T_BONE_STEAK.getName(), 2);
        order.put(CHOCOLATE_CAKE.getName(), 1);

        orderItems = OrderItems.from(order);
        totalAmount = TotalAmount.from(orderItems);
    }

    // 나중에 @Parametrized 사용
    @Test
    public void 주문한_메뉴들의_총_금액을_구한다() {
        totalAmount = TotalAmount.from(orderItems);
        int expectedAmount = T_BONE_STEAK.getPrice() * 2 + CHOCOLATE_CAKE.getPrice();

        assertEquals(expectedAmount, totalAmount.getAmount());
    }

}