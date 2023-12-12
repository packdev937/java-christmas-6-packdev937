package christmas.utils.messages;

public enum ErrorMessage {
    INVALID_RANGE("유효하지 않은 범위입니다."),
    INVALID_DIVISION_BY_ZERO("0으로 나눌 수 없습니다."),
    INVALID_INPUT_FORMAT("유효하지 않은 입력 형식입니다."),
    INVALID_INPUT("입력이 유효하지 않습니다."),
    NOT_EXIST("존재하지 않습니다.");


    private final String message;
    private static final String prefix = "[ERROR] ";


    ErrorMessage(String message) {
        this.message = prefix+message;
    }

    public String getMessage() {
        return message;
    }
}
