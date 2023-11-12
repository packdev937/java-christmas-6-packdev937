package christmas.domain.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Benefits {

    private final List<Benefit> benefits;

    private Benefits() {
        this.benefits = new ArrayList<>();
    }

    public static Benefits getInstance() {
        return new Benefits();
    }

    public void addBenefit(Benefit benefit) {
        benefits.add(benefit);
    }

    public int getTotalBenefits() {
        return benefits.stream().mapToInt(Benefit::getDiscountAmount).sum();
    }

    public List<Benefit> getBenefits() {
        return Collections.unmodifiableList(benefits);
    }
}