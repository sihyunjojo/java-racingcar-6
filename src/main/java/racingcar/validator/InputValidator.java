package racingcar.resolver;

import static racingcar.exception.ErrorMessage.*;
import static racingcar.view.InputView.read;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.InputUtil;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public List<String> preprocessCarName() {
        String carNames = read();

        List<String> carNameList = InputUtil.convertInputStringToList(carNames)
                .stream()
                .map(String::trim)
                .distinct()
                .toList();

        return limitNameSize(carNameList);
    }

    private static List<String> limitNameSize(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(VALIDATE_LENGTH_FOR_EACH_CAR_NAME.getMessage());
            }
        }
        return carNameList;
    }

    public int preprocessCount() {
        String count = read();

        return stringToInt(count.trim());
    }

    private static int stringToInt(String trimInput) {
        int count;
        try {
            count = Integer.parseInt(trimInput);
        } catch (Exception e) {
            Console.close();
            throw new IllegalArgumentException(VALIDATE_DIGIT_FOR_INPUT.getMessage());
        }
        return count;
    }

}
