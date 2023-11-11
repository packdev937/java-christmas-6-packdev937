package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.time.LocalDate;

public class InputView {

    public static final String EXPECTED_VISIT_DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static LocalDate readVisitDate() {
        try {
            System.out.println(EXPECTED_VISIT_DATE_PROMPT);
            int day = Integer.parseInt(Console.readLine());
            return LocalDate.of(2023, 12, day);
        } catch (NumberFormatException error) {
            OutputView.printErrorMessage("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return readVisitDate();
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error.getMessage());
            return readVisitDate();
        }
    }

}
