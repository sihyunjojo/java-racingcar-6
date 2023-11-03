package racingcar.controller;

import static racingcar.view.message.SystemMessage.RACE_STATUS;
import static racingcar.view.message.SystemMessage.RACE_WINNERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Game;
import racingcar.dto.CarResult;
import racingcar.util.OutputUtil;
import racingcar.validator.InputValidator;
import racingcar.service.GameService;
import racingcar.view.OutputView;
import racingcar.view.message.SystemMessage;

public class GameController {

    private final GameService gameService;
    private final InputValidator inputValidator;

    public GameController(GameService gameService, InputValidator inputValidator) {
        this.gameService = gameService;
        this.inputValidator = inputValidator;
    }

    public void game(){
        List<String> carNames = inputValidator.preprocessCarName();
        int count = inputValidator.preprocessCount();
        Game game = gameService.settingGame(carNames,count);

        racingGame(game);

        finishGame(game);

    }

    private void racingGame(Game game) {
        OutputView.printSystemMessage(RACE_STATUS);

        for (int i = 0; i < game.getCount(); i++) {
            List<CarResult> carResults = gameService.startGame(game);
            List<String> carResultByOutput = OutputUtil.generateCarResultString(carResults);

            OutputView.printMessagesWithBlankLine(carResultByOutput);
        }
    }

    private void finishGame(Game game) {
        List<String> winnerCarNameList = gameService.determineWinner(game);
        String winners = OutputUtil.joinUsingCommaByList(winnerCarNameList);

        OutputView.printMessage(RACE_WINNERS + winners);
        Console.close();
    }
}
