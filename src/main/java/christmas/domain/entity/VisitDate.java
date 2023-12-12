package christmas.domain.entity;

import static christmas.utils.constants.IntegerConstant.*;
import static christmas.utils.validation.IntegerValidator.*;

public class VisitDate {

    private final int visitDate;

    private VisitDate(int visitDate) {
        validateNumberInRange(visitDate, MINIMUM_DATE_RANGE.getValue(), MAXIMUM_DATE_RANGE.getValue());
        this.visitDate = visitDate;
    }

    public static VisitDate of(int visitDate) {
        return new VisitDate(visitDate);
    }
}
