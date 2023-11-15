package christmas.domain.discount;

import christmas.domain.event.Benefit;
import christmas.domain.event.Benefits;
import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import christmas.domain.menu.MenuItem;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPolicies {

    private final int BENEFIT_CRITERION = 10000;
    private final List<DiscountPolicy> policies;

    public DiscountPolicies(List<DiscountPolicy> discountPolicies) {
        this.policies = discountPolicies;
    }

    public Benefits createBenefits(DiscountContext discountContext,
        TotalAmount totalAmount, Promotion promotion) {
        if (!isTotalAmountEnough(totalAmount)) {
            return Benefits.emptyBenefits();
        }
        List<Benefit> benefits = calculateApplicableBenefits(discountContext);
        applyPromotionToBenefits(benefits, promotion);

        return Benefits.from(benefits, promotion);
    }

    private boolean isTotalAmountEnough(TotalAmount totalAmount) {
        return totalAmount.value() >= BENEFIT_CRITERION;
    }

    private List<Benefit> calculateApplicableBenefits(DiscountContext discountContext) {
        return policies.stream()
            .filter(policy -> policy.isApplicable(discountContext))
            .map(policy -> Benefit.of(policy.getDescription(),
	policy.calculateDiscount(discountContext)))
            .collect(Collectors.toList());
    }

    private void applyPromotionToBenefits(List<Benefit> benefits, Promotion promotion) {
        if (promotion.item() != MenuItem.NONE) {
            benefits.add(Benefit.of(promotion.getDescription(), promotion.item().getPrice()));
        }
    }

    public List<DiscountPolicy> asList() {
        return Collections.unmodifiableList(policies);
    }
}

