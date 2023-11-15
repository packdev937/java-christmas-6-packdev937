package christmas.domain.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Benefit 클래스")
public class BenefitTest {

    @Test
    void 할인_정책의_이름을_출력한다() {
        String expectedDescription = "할인 정책";
        Benefit benefit = Benefit.of(expectedDescription, 10);
        String actualDescription = benefit.getDescription();

        assertEquals(expectedDescription, actualDescription, "설명은 '무료 배송'이어야 한다");
    }

    @Test
    public void 할인_금액이_1000일_때_1000을_반환한다() {
        int expectedDiscountAmount = 1000;
        Benefit benefit = Benefit.of("할인 정책", expectedDiscountAmount);
        int actualDiscountAmount = benefit.getDiscountAmount();

        assertEquals(expectedDiscountAmount, actualDiscountAmount);
    }
}
