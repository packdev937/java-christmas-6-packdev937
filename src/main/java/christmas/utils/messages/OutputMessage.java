package christmas.utils.messages;

public enum OutputMessage {
    EVENT_START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"),
    EVENT_ANNOUCEMENT_MESSAGE("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENU_MESSAGE("<주문 메뉴>\n"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT_MESSAGE("<할인 전 총주문 금액>\n"),
    GIFT_MESSAGE("<증정 메뉴>\n"),
    BENEFIT_LIST_MESSAGE("<혜택 내역>\n"),
    TOTAL_BENEFIT_MESSAGE("<총혜택 금액>\n"),
    TOTAL_AMOUNT_AFTER_DISCOUNT_MESSAGE("<할인 후 예상 결제 금액>\n"),
    BADGE_MESSAGE("<%d월 이벤트 배지>\n"),
    NOTHING("없음\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
