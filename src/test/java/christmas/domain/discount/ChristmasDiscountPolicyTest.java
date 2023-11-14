package christmas.domain.discount;

import christmas.domain.event.VisitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ChristmasDiscountPolicy 클래스")
public class ChristmasDiscountPolicyTest {

    private ChristmasDiscountPolicy christmasDiscountPolicy;
    private DiscountContext discountContext;

    @BeforeEach
    public void setUp() {
        christmasDiscountPolicy = new ChristmasDiscountPolicy();
        discountContext = DiscountContext.of(VisitDate.from(LocalDate.of(2022, 12, 25)), null);
    }

    @Test
    void 할인_정책의_이름을_출력한다() {
        String description = christmasDiscountPolicy.getDescription();
        assertEquals("크리스마스 디데이 할인", description);
    }

    @Test
    void 크리스마스_기간_내에_있다면_할인_정책을_적용한다() {
        discountContext = DiscountContext.of(VisitDate.from(LocalDate.of(2022, 12, 25)), null);
        boolean isApplicable = christmasDiscountPolicy.isApplicable(discountContext);
        assertTrue(isApplicable);
    }

    @Test
    void 크리스마스_기간을_지났다면_할인_정책이_적용되지_않는다() {
        discountContext = DiscountContext.of(VisitDate.from(LocalDate.of(2022, 12, 26)), null);
        boolean isApplicable = christmasDiscountPolicy.isApplicable(discountContext);
        assertFalse(isApplicable);
    }

    @Test
    void 날마다_100원씩_누적된다() {
        discountContext = DiscountContext.of(VisitDate.from(LocalDate.of(2022, 12, 2)), null);
        int discount = christmasDiscountPolicy.calculateDiscount(discountContext);
        assertEquals(1100, discount);
    }

    @Test
    void 크리스마스_기간이_지났다면_할인_혜택은_0원이다() {
        discountContext = DiscountContext.of(VisitDate.from(LocalDate.of(2022, 12, 26)), null);
        int discount = christmasDiscountPolicy.calculateDiscount(discountContext);
        assertEquals(0, discount);
    }
}
