package christmas.domain.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.utils.ConstantUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("EventBadge 클래스")
public class EventBadgeTest {

    private final int STAR_CRITERION = 5000;
    private final int TREE_CRITERION = 10000;
    private final int SANTA_CRITERION = 20000;

    @Test
    void 혜택_금액이_산타_기준값과_같을_때_산타_뱃지를_반환한다() {
        int benefitAmount = SANTA_CRITERION;
        EventBadge result = EventBadge.getBadgeByAmount(benefitAmount);

        assertEquals(EventBadge.SANTA, result);
    }

    @Test
    void 혜택_금액이_트리_기준값과_같을_때_트리_뱃지를_반환한다() {
        int benefitAmount = TREE_CRITERION;
        EventBadge result = EventBadge.getBadgeByAmount(benefitAmount);

        assertEquals(EventBadge.TREE, result);
    }

    @Test
    void 혜택_금액이_별_기준값과_같을_때_별_뱃지를_반환한다() {
        int benefitAmount = STAR_CRITERION;
        EventBadge result = EventBadge.getBadgeByAmount(benefitAmount);

        assertEquals(EventBadge.STAR, result);
    }

    @Test
    void 혜택_금액이_별_기준값보다_적을_때_뱃지_없음을_반환한다() {
        int benefitAmount = NONE;
        EventBadge result = EventBadge.getBadgeByAmount(benefitAmount);

        assertEquals(EventBadge.NONE, result);
    }
}
