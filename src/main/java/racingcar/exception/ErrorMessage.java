package racingcar.exception;

public enum ErrorMessage {
    VALIDATE_LENGTH_FOR_EACH_CAR_NAME("이름은 5자 이하만 가능하다."),
    VALIDATE_DIGIT_FOR_INPUT("입력값은 숫자이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
