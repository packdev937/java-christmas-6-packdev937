package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static final String EXPECTED_VISIT_DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_MENU_PROMPT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final Pattern ORDER_PATTERN = Pattern.compile("([\\p{L}\\s]+)-(\\d+)");

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

    public static Map<String, Integer> readOrderMenu() {
        try {
            System.out.println(ORDER_MENU_PROMPT);
            String input = Console.readLine();
            return parseInput(input);
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error.getMessage());
            return readOrderMenu();
        }
    }

    private static Map<String, Integer> parseInput(String input) {
        Map<String, Integer> orderItems = new HashMap<>();
        List<String> inputs = List.of(input.split(","));

        inputs.stream().forEach(item -> {
            Matcher matcher = ORDER_PATTERN.matcher(item.trim());
            if (!matcher.matches()) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            try {
                int quantity = Integer.parseInt(matcher.group(2).trim());
                orderItems.put(matcher.group(1).trim(), quantity);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 숫자를 입력해주세요.");
            }
        });

        return orderItems;
    }

    private InputView() {
    }
}
