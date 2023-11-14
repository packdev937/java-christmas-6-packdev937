package christmas.view;


import camp.nextstep.edu.missionutils.Console;
import christmas.domain.event.VisitDate;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderItemFactory;
import christmas.domain.order.OrderItems;
import christmas.domain.order.OrderParser;
import java.time.LocalDate;
import java.util.Map;

public class InputView {

    public static final String EXPECTED_VISIT_DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_MENU_PROMPT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static VisitDate readVisitDate() {
        try {
            System.out.println(EXPECTED_VISIT_DATE_PROMPT);
            int day = Integer.parseInt(Console.readLine());
            return VisitDate.from(LocalDate.of(2023, 12, day));
        } catch (NumberFormatException error) {
            OutputView.printErrorMessage("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return readVisitDate();
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error.getMessage());
            return readVisitDate();
        }
    }

    public static OrderItems readOrderMenu() {
        try {
            System.out.println(ORDER_MENU_PROMPT);
            String input = Console.readLine();
            Map<String, Integer> parsedOrder = OrderParser.parseInput(input);
            Map<MenuItem, Integer> convertedOrder = OrderItemFactory.convertToMenuItems(
	parsedOrder);
            return OrderItems.from(convertedOrder);
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error.getMessage());
            return readOrderMenu();
        }
    }

    private InputView() {
    }
}
