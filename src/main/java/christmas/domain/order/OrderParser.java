package christmas.domain.order;

import static christmas.utils.ConstantUtils.*;
import static christmas.utils.ConstantUtils.ORDER_ERROR_PREFIX;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderParser {

    private static final Pattern ORDER_PATTERN = Pattern.compile("([\\p{L}\\s]+)-(\\d+)");
    private final String input;

    private OrderParser(String input) {
        validateInput(input);
        this.input = input;
    }

    public static OrderParser from(String input) {
        return new OrderParser(input);
    }

    public Map<String, Integer> parseInput() {
        Map<String, Integer> orderItems = new HashMap<>();
        for (String item : List.of(input.split(DELIMITER))) {
            Matcher matcher = ORDER_PATTERN.matcher(item.trim());
            if (!matcher.matches()) {
	throw new IllegalArgumentException(ORDER_ERROR_PREFIX);
            }
            if (orderItems.containsKey(matcher.group(1).trim())) {
	throw new IllegalArgumentException(
	    ORDER_ERROR_PREFIX);
            }
            orderItems.put(matcher.group(1).trim(), Integer.parseInt(matcher.group(2).trim()));
        }
        return orderItems;
    }

    private void validateInput(String input) {
        validateNotEmpty(input);
        validateNoSpaceInString(input);
        validateNotStartOrEndWithComma(input);
        validateNoConsecutiveCommas(input);
        validateNoCommasWithSpaces(input);
    }

    private void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }
    }

    private void validateNoSpaceInString(String input) {
        if (input.contains(SPACE)) {
            throw new IllegalArgumentException("입력에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateNotStartOrEndWithComma(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("입력의 시작 혹은 끝에 쉼표가 있습니다.");
        }
    }

    private void validateNoConsecutiveCommas(String input) {
        if (input.contains(DELIMITER.repeat(2))) {
            throw new IllegalArgumentException("쉼표가 연속해서 있습니다.");
        }
    }

    private void validateNoCommasWithSpaces(String input) {
        if (input.contains(SPACE + DELIMITER) || input.contains(DELIMITER + SPACE)) {
            throw new IllegalArgumentException("쉼표 옆에 공백이 있습니다.");
        }
    }
}
