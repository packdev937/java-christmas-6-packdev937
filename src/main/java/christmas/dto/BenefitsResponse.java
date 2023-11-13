package christmas.dto;

import christmas.domain.event.Benefit;
import java.util.List;

public record BenefitsResponse(List<Benefit> benefits) {

    public BenefitsResponse(List<Benefit> benefits) {
        this.benefits = benefits;
    }
}
