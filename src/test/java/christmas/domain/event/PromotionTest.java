package christmas.domain.event;

import christmas.domain.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Promotion 클래스")
public class PromotionTest {

    private Promotion promotion;

    @BeforeEach
    void setUp() {
        promotion = Promotion.from(TotalAmount.from(120000));
    }

    @ParameterizedTest
    @CsvSource({
        "130000", "120000"
    })
    void 총_금액이_프로모션_기준과_같거나_그_이상일_때_샴페인_프로모션을_반환한다(int totalAmount) {
        Promotion result = Promotion.from(TotalAmount.from(totalAmount));

        assertThat(result.item()).isEqualTo(MenuItem.CHAMPAGNE);
    }

    @Test
    void 총_금액이_프로모션_기준_미만일_때_프로모션_없음을_반환한다() {
        int totalAmount = 110000;
        Promotion result = Promotion.from(TotalAmount.from(totalAmount));

        assertThat(result.item()).isEqualTo(MenuItem.NONE);
    }


    @Test
    void item_메소드는_프로모션_아이템을_반환한다() {
        MenuItem result = promotion.item();

        assertThat(result).isEqualTo(MenuItem.CHAMPAGNE);
    }
}
