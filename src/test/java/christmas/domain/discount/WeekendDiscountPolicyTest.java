package christmas.domain.discount;

import christmas.domain.event.VisitDate;
import christmas.domain.order.OrderItems;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.utils.ConstantUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static christmas.utils.ConstantUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WeekendDiscountPolicy 클래스")
public class WeekendDiscountPolicyTest {

    private final int DISCOUNT_CRITERION = 2023;
    private WeekendDiscountPolicy weekendDiscountPolicy;

    @BeforeEach
    public void setUp() {
        weekendDiscountPolicy = new WeekendDiscountPolicy();
    }

    @Test
    void 할인_정책의_이름을_출력한다() {
        String description = weekendDiscountPolicy.getDescription();
        assertEquals("주말 할인", description);
    }

    @Test
    void 평일에_할인_혜택을_적용하지_않는다() {
        VisitDate weekday = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3));
        DiscountContext weekdayContext = DiscountContext.of(weekday, null);

        assertFalse(weekendDiscountPolicy.isApplicable(weekdayContext));
    }

    @Test
    void 주말에는_할인_혜택을_적용한다() {
        VisitDate weekend = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1));
        DiscountContext weekendContext = DiscountContext.of(weekend, null);

        assertTrue(weekendDiscountPolicy.isApplicable(weekendContext));
    }

    @Test
    void 주말에는_메인_개수만큼_할인_혜택을_적용한다() {
        VisitDate weekdayVisitDate = VisitDate.from(
            LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1));

        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.T_BONE_STEAK, 2);
        order.put(MenuItem.BBQ_RIBS, 1);
        OrderItems orderItems = OrderItems.from(order);

        DiscountContext context = DiscountContext.of(weekdayVisitDate, orderItems);

        assertEquals(order.size() * DISCOUNT_CRITERION,
            weekendDiscountPolicy.calculateDiscount(context));
    }

    @Test
    void 메인_이외의_메뉴는_할인_혜택이_적용되지_않는다() {
        VisitDate weekdayVisitDate = VisitDate.from(
            LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1));

        Map<MenuItem, Integer> order = new HashMap<>();
        order.put(MenuItem.CHOCOLATE_CAKE, 2);
        order.put(MenuItem.RED_WINE, 1);
        OrderItems orderItems = OrderItems.from(order);

        DiscountContext context = DiscountContext.of(weekdayVisitDate, orderItems);

        assertEquals(0,
            weekendDiscountPolicy.calculateDiscount(context));
    }
}
