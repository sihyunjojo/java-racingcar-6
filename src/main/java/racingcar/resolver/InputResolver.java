package racingcar.resolver;

import static racingcar.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class InputResolver {

    private static final int MAX_NAME_LENGTH = 5;
    private final InputView inputView;
    public InputResolver(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> preprocessCarName() {
        String carNames = inputView.inputCarNames();

        List<String> carNameList = Arrays.stream(carNames.split(","))
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
        String count = inputView.inputCount();

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
