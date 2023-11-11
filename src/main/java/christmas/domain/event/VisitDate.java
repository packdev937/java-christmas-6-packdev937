package christmas.domain.event;

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
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("날짜는 1일에서 31일 사이어야 합니다.");
        }
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }
}
