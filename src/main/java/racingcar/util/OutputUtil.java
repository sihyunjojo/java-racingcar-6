package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarResult;

public class OutputUtil {

    public static List<String> generateCarResultString(List<CarResult> carResults) {
        return carResults.stream()
                .map(carResult ->
                        carResult.getCarName() + " : " + "-".repeat(carResult.getCarDistances()))
                .collect(Collectors.toList());
    }
    public static String joinUsingCommaByList(List<String> input) {
        return String.join(",", input);
    }
}
