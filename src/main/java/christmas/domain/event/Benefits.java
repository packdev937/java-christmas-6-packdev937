package christmas.domain.event;

import christmas.dto.BenefitsResponse;
import java.util.List;

public class Benefits {

    private final List<Benefit> benefits;

    private Benefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public static Benefits from(List<Benefit> benefits) {
        return new Benefits(benefits);
    }

    public int calculateTotalBenefits() {
        return benefits.stream().mapToInt(Benefit::getDiscountAmount).sum();
    }

    public BenefitsResponse toResponse() {
        return new BenefitsResponse(benefits);
    }
}