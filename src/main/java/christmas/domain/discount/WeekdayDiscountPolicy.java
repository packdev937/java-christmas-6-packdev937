package christmas.domain.discount;

import static christmas.utils.ConstantUtils.*;

import christmas.domain.menu.MenuType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT_PER_DESSERT = 2023;
    private final String description = "평일 할인";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isApplicable(DiscountContext discountContext) {
        DayOfWeek dayOfWeek = LocalDate.of(EVENT_YEAR, EVENT_MONTH,
            discountContext.getVisitDate().getDay()).getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    @Override
    public int calculateDiscount(DiscountContext discountContext) {
        if (!isApplicable(discountContext)) {
            return 0;
        }
        return discountContext.getOrderItems().getItemsByType(MenuType.DESSERT)
            .entrySet()
            .stream()
            .mapToInt(entry -> entry.getValue())
            .sum() * DISCOUNT_AMOUNT_PER_DESSERT;
    }
}