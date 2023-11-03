package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;


class InputResolverTest {

    private InputValidator inputValidator;

    @BeforeEach
    void beforeSetting(){
        inputValidator = new InputValidator();
    }

    @AfterEach
    void afterSetting(){
        System.setIn(System.in);
    }

    @Test
    @DisplayName("5글자 초과의 차 이름이 들어가면 IllegalArgumentException를 일으킨다.")
    void testPreprocessCarNameWithInvalidInput() {
        // 입력 값을 설정
        String input = "Car1, Car222, Car3"; // Car2가 5자 초과
        setSystemIn(input);

        // 예외 검증
        assertThrows(IllegalArgumentException.class, inputValidator::preprocessCarName);
    }
    @Test
    @DisplayName("숫자가 아닌 값이 들어가면 IllegalArgumentException를 일으킨다.")
    void testPreprocessCountWithInvalidInput() {
        // 입력 값을 설정
        String input = "invalid";
        setSystemIn(input);

        // 예외 검증
        assertThrows(IllegalArgumentException.class, inputValidator::preprocessCount);
    }

    private void setSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}