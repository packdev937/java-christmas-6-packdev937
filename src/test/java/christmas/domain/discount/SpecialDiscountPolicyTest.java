package christmas.domain.discount;

import christmas.domain.event.VisitDate;
import christmas.utils.ConstantUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static christmas.utils.ConstantUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SpecialDiscountPolicy 클래스")
class SpecialDiscountPolicyTest {

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private SpecialDiscountPolicy specialDiscountPolicy;

    @BeforeEach
    void setUp() {
        specialDiscountPolicy = new SpecialDiscountPolicy();
    }

    @Test
    void 할인_정책의_이름을_출력한다() {
        String description = specialDiscountPolicy.getDescription();
        assertEquals("특별 할인", description);
    }

    @Test
    void 만약에_달력에_별이있다면_특별_할인을_적용한다() {
        VisitDate visitDate = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3));
        DiscountContext discountContext = DiscountContext.of(visitDate, null);
        boolean isApplicable = specialDiscountPolicy.isApplicable(discountContext);
        assertTrue(isApplicable);
    }

    @Test
    void 만약에_달력에_별이없다면_특별_할인을_적용하지_않는다() {
        VisitDate visitDate = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 2));
        DiscountContext discountContext = DiscountContext.of(visitDate, null);
        boolean isApplicable = specialDiscountPolicy.isApplicable(discountContext);
        assertFalse(isApplicable);
    }

    @Test
    void 특별_할인이_적용되면_1000원이_할인된다() {
        VisitDate visitDate = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3));
        DiscountContext discountContext = DiscountContext.of(visitDate, null);
        int discount = specialDiscountPolicy.calculateDiscount(discountContext);
        assertEquals(SPECIAL_DISCOUNT_AMOUNT, discount);
    }

    @Test
    void 특별_할인이_적용되지_않으면_0원을_반환한다() {
        VisitDate visitDate = VisitDate.from(LocalDate.of(EVENT_YEAR, EVENT_MONTH, 2));
        DiscountContext discountContext = DiscountContext.of(visitDate, null);
        int discount = specialDiscountPolicy.calculateDiscount(discountContext);
        assertEquals(NONE, discount);
    }
}
