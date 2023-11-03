package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.OutputView.*;
import static racingcar.view.message.SystemMessage.*;


public class InputView {
    //    private 생성자를 사용하여 외부에서 이 클래스의 객체를 생성하는 것을 막고 있습니다.
    //    private 생성자를 사용하여 외부에서 이 클래스의 객체를 생성하는 것을 막고 있습니다.
    private InputView() {
    }
    public static String inputCarNames() {
        printSystemMessage(READ_CAR_NAMES);
        return readLine();
    }

    public static String inputCount() {
        printSystemMessage(READ_TRY_COUNT);
        return readLine();
    }
}
