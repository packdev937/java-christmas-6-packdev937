package christmas.view;

import java.text.DecimalFormat;

public class OutputView {

    public static final String EVENT_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_ANNOUNCEMENT_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE = "\n<할인 전 총주문 금액>";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final DecimalFormat formatter = new DecimalFormat("#,###원");


    public static void printEventStartMessage() {
        System.out.println(EVENT_START_MESSAGE);
    }

    public static void printEventAnnouncement(int visitDate) {
        System.out.printf(EVENT_ANNOUNCEMENT_MESSAGE, visitDate);
    }

    public static void printTotalAmountBeforeDiscount(int amount) {
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_MESSAGE);
        System.out.println(formatter.format(amount));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
