package christmas.domain.discount;

import static christmas.utils.ConstantUtils.*;

public class ChristmasDiscountPolicy implements DiscountPolicy {

    private static final int START_DISCOUNT_CRITERION = 1000;
    private static final int DAILY_INCREMENT_CRITERION = 100;

    private final String description = "크리스마스 디데이 할인";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isApplicable(DiscountContext discountContext) {
        int visitDay = discountContext.getVisitDate().getDay();
        return visitDay >= START_DAY && visitDay <= CHRISTMAS_DAY;
    }

    @Override
    public int calculateDiscount(DiscountContext discountContext) {
        if (!isApplicable(discountContext)) {
            return 0;
        }
        int cumulativeDay =
            discountContext.getVisitDate().getDay() - START_DAY;
        return START_DISCOUNT_CRITERION + (cumulativeDay * DAILY_INCREMENT_CRITERION);
    }
}
