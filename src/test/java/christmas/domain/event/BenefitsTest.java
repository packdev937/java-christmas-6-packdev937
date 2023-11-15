package christmas.domain.event;

import christmas.dto.BenefitsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Benefits 클래스")
public class BenefitsTest {

    @Test
    void 비어있지_않은_경우_할인_금액의_합계를_계산한다() {
        Benefit benefit1 = Benefit.of("100원 할인 정책", 100);
        Benefit benefit2 = Benefit.of("1000원 할인 정책", 1000);
        Promotion promotion = Promotion.from(120000);
        Benefits benefits = Benefits.from(Arrays.asList(benefit1, benefit2), promotion);

        int totalBenefits = benefits.calculateTotalBenefits();

        assertEquals(1100, totalBenefits);
    }

    @Test
    void 혜택이_비어_있는_경우_0을_반환한다() {
        Benefits benefits = Benefits.emptyBenefits();

        int totalBenefits = benefits.calculateTotalBenefits();

        assertEquals(0, totalBenefits);
    }

    @Test
    void 동일한_데이터를_BenefitsResponse를_통해_반환한다() {
        Benefit benefit1 = Benefit.of("100원 할인", 100);
        Benefit benefit2 = Benefit.of("1000원 할인", 1100);
        Promotion promotion = Promotion.from(120000);
        Benefits benefits = Benefits.from(Arrays.asList(benefit1, benefit2), promotion);

        BenefitsResponse response = benefits.toResponse();

        assertEquals(2, response.benefits().size());
        assertEquals("100원 할인", response.benefits().get(0).getDescription());
        assertEquals(100, response.benefits().get(0).getDiscountAmount());
        assertEquals("1000원 할인", response.benefits().get(1).getDescription());
        assertEquals(1100, response.benefits().get(1).getDiscountAmount());
    }

    @Test
    void 비어_있는_경우_빈_BenefitsResponse를_반환한다() {
        Benefits benefits = Benefits.emptyBenefits();
        BenefitsResponse response = benefits.toResponse();

        assertEquals(0, response.benefits().size());
    }
}
