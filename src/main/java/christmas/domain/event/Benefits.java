package christmas.domain.event;

import christmas.domain.menu.MenuItem;
import christmas.dto.BenefitsResponse;
import java.util.List;

public class Benefits {

    private final List<Benefit> benefits;
    private final Promotion promotion;

    private Benefits(List<Benefit> benefits, Promotion promotion) {
        this.benefits = benefits;
        this.promotion = promotion;
    }

    public static Benefits from(List<Benefit> benefits, Promotion promotion) {
        return new Benefits(benefits, promotion);
    }

    public int calculateTotalBenefits() {
        return benefits.stream().mapToInt(Benefit::getDiscountAmount).sum();
    }

    public int calculateFinalAmount(int totalAmount) {
        int totalBenefits = calculateTotalBenefits();
        if (promotion != null && promotion.item().equals(MenuItem.CHAMPAGNE)) {
            totalBenefits -= promotion.item().getPrice();
        }
        return totalAmount - totalBenefits;
    }

    public BenefitsResponse toResponse() {
        return new BenefitsResponse(benefits);
    }
}