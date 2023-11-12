package christmas.domain.discount;

public interface DiscountPolicy {
    String getDescription();

    boolean isApplicable(DiscountContext discountContext);

    int calculateDiscount(DiscountContext discountContext);
}
