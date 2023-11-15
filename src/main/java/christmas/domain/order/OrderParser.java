package christmas.domain.order;

import static christmas.utils.ConstantUtils.ORDER_ERROR_PREFIX;
import static christmas.utils.ConstantUtils.RETRY_INPUT_MESSAGE;

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
	throw new IllegalArgumentException(ORDER_ERROR_PREFIX);
            }
            String menuName = matcher.group(1).trim();
            int quantity = Integer.parseInt(matcher.group(2).trim());

            if (orderItems.containsKey(menuName)) {
	throw new IllegalArgumentException(
	    ORDER_ERROR_PREFIX);
            }

            orderItems.put(menuName, quantity);
        }

        return orderItems;
    }
}
