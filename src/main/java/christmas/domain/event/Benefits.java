package christmas.domain.event;

import static christmas.utils.ConstantUtils.*;

import christmas.dto.BenefitsResponse;
import java.util.Collections;
import java.util.List;

public class Benefits {

    private final List<Benefit> benefits;

    private Benefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public static Benefits from(List<Benefit> benefits) {
        return new Benefits(benefits);
    }

    public static Benefits emptyBenefits() {
        return new Benefits(Collections.emptyList());
    }

    public int calculateTotalBenefits() {
        return benefits.stream().mapToInt(Benefit::getDiscountAmount).sum();
    }

    public BenefitsResponse toResponse() {
        return new BenefitsResponse(benefits);
    }
}