package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.entity.VisitDate;
import christmas.utils.messages.InputMessages;

public class InputView {

    public VisitDate readVisitDate() {
        try {
            System.out.print(InputMessages.VISIT_DATE_PROMPT.getMessage());
            int visitDate = Integer.parseInt(Console.readLine());
            return VisitDate.of(visitDate);
        } catch (IllegalArgumentException error) {
            System.out.print(error.getMessage());
            return readVisitDate();
        }
    }
}
