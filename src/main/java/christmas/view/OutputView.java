package christmas.view;

import christmas.domain.event.EventBadge;
import christmas.domain.menu.MenuItem;
import christmas.dto.BenefitsResponse;
import christmas.dto.OrderItemsResponse;
import java.text.DecimalFormat;

public class OutputView {

    public static final String EVENT_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_ANNOUNCEMENT_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String ORDER_MENU_MESSAGE = "\n<주문 메뉴>";
    public static final String PROMOTION_MESSAGE = "\n<증정 메뉴>";
    public static final String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE = "\n<할인 전 총주문 금액>";
    public static final String EXPECTED_AMOUNT_AFTER_DISCOUNT_MESSAGE = "\n<할인 후 예상 결제 금액>";
    public static final String TOTAL_BENEFIT_MESSAGE = "\n<총혜택 금액>";

    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NONE_MESSAGE = "없음";

    private static final DecimalFormat formatter = new DecimalFormat("#,###원");


    public static void printEventStartMessage() {
        System.out.println(EVENT_START_MESSAGE);
    }

    public static void printEventAnnouncement(int visitDate) {
        System.out.printf(EVENT_ANNOUNCEMENT_MESSAGE, visitDate);
    }

    public static void printOrderItems(OrderItemsResponse response) {
        System.out.println(ORDER_MENU_MESSAGE);
        response.orderItems().forEach((menuItem, quantity) ->
            System.out.println(menuItem.getName() + " " + quantity + "개"));
    }

    public static void printTotalAmountBeforeDiscount(int amount) {
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE);
        System.out.println(formatter.format(amount));
    }

    public static void printExpectedAmountAfterDiscount(int finalAmount) {
        System.out.println(EXPECTED_AMOUNT_AFTER_DISCOUNT_MESSAGE);
        System.out.println(formatter.format(finalAmount));
    }

    public static void printPromotionItem(MenuItem item) {
        System.out.println(PROMOTION_MESSAGE);
        System.out.println(item.getName());
    }

    public static void printTotalBenefits(int totalBenefits) {
        System.out.println(TOTAL_BENEFIT_MESSAGE);
        System.out.println(formatter.format(-totalBenefits));
    }

    public static void printNone() {
        System.out.print(NONE_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
