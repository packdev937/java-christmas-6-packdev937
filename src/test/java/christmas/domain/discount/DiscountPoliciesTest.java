package christmas.domain.discount;

import christmas.domain.event.Benefits;
import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DiscountPolicies 클래스")
public class DiscountPoliciesTest {

    private DiscountPolicies discountPolicies;

    @BeforeEach
    public void setUp() {
        discountPolicies = new DiscountPolicies(
            Arrays.asList(
	new ChristmasDiscountPolicy(),
	new WeekdayDiscountPolicy(),
	new WeekendDiscountPolicy(),
	new SpecialDiscountPolicy()
            )
        );
    }

    @Test
    void 할인_정책이_리스트_형태로_올바르게_관리된다() {
        List<DiscountPolicy> polices = discountPolicies.asList();

        assertEquals(4, polices.size());
        assertTrue(polices.get(0) instanceof ChristmasDiscountPolicy);
        assertTrue(polices.get(1) instanceof WeekdayDiscountPolicy);
        assertTrue(polices.get(2) instanceof WeekendDiscountPolicy);
        assertTrue(polices.get(3) instanceof SpecialDiscountPolicy);
    }

    @Test
    void 할인_전_총금액이_10000원_미만이면_할인_혜택은_적용되지_않는다() {
        TotalAmount totalAmount = TotalAmount.from(9000);
        Promotion promotion = Promotion.from(totalAmount);
        DiscountContext discountContext = DiscountContext.of(null, null);

        Benefits benefits = discountPolicies.createBenefits(discountContext, totalAmount,
            promotion);

        assertEquals(0, benefits.calculateTotalBenefits());
    }

    @Test
    void UnmodifiableList를_반환한다() {
        List<DiscountPolicy> policies = discountPolicies.asList();

        assertThrows(UnsupportedOperationException.class,
            () -> policies.add(new ChristmasDiscountPolicy()));
    }
}
