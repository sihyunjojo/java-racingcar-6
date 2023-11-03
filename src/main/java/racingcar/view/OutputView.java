package racingcar.view;

import static racingcar.view.message.SystemMessage.*;

import java.util.List;
import racingcar.view.message.SystemMessage;


public class OutputView {
    //    private 생성자를 사용하여 외부에서 이 클래스의 객체를 생성하는 것을 막고 있습니다.
    private OutputView() {
    }
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static <T> void printMessagesWithBlankLine(List<T> messages) {
        messages.forEach(System.out::println);
        printMessageBlankLine();
    }

    public static void printMessageBlankLine() {
        System.out.println();
    }

    public static <T> void printMessage(T message) {
        System.out.println(message);
    }

}
//
//public class OutputView {
//    public void outputResultString() {
//        System.out.println();
//        System.out.println(RACE_STATUS.getMessage());
//    }
//
//    public void outputGameResult(List<CarResult> gameResults) {
//        gameResults
//                .forEach(gameResult -> {
//                    System.out.println(gameResult.getCarName() + " : " + "-".repeat(gameResult.getCarDistances()));
//                });
//        System.out.println();
//    }
//
//    public void outputGameWinner(List<String> winnerCarNameList) {
//        System.out.println(RACE_WINNERS.getMessage() + String.join(", ", winnerCarNameList));
//    }
//}
