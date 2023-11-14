package christmas.domain.order;

import static christmas.utils.ConstantUtils.ORDER_ERROR_PREFIX;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderParser {

    private static final Pattern ORDER_PATTERN = Pattern.compile("([\\p{L}\\s]+)-(\\d+)");

    public static Map<String, Integer> parseInput(String input) {
        Map<String, Integer> orderItems = new HashMap<>();
        List<String> inputs = List.of(input.split(","));

        for (String item : inputs) {
            Matcher matcher = ORDER_PATTERN.matcher(item.trim());
            if (!matcher.matches()) {
	throw new IllegalArgumentException(ORDER_ERROR_PREFIX + "다시 입력해 주세요.");
            }
            int quantity = Integer.parseInt(matcher.group(2).trim());
            orderItems.put(matcher.group(1).trim(), quantity);
        }

        return orderItems;
    }
}
