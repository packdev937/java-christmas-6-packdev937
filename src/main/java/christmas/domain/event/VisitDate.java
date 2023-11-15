package christmas.domain.event;

import static christmas.utils.ConstantUtils.*;

import java.time.LocalDate;

public class VisitDate {

    private final LocalDate localDate;

    private VisitDate(LocalDate localDate) {
        validateDayInRange(localDate.getDayOfMonth());
        this.localDate = localDate;
    }

    public static VisitDate from(LocalDate localDate) {
        return new VisitDate(localDate);
    }

    private void validateDayInRange(int day) {
        if (day < START_DAY || day > END_DAY) {
            throw new IllegalArgumentException("날짜는 1이상 31이하의 숫자입니다.");
        }
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }
}
