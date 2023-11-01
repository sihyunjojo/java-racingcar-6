package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Game;
import racingcar.dto.GameResult;
import racingcar.resolver.InputResolver;
import racingcar.service.GameService;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final OutputView outputView;
    private final InputResolver inputResolver;

    public GameController(GameService gameService, OutputView outputView, InputResolver inputResolver) {
        this.gameService = gameService;
        this.outputView = outputView;
        this.inputResolver = inputResolver;
    }

    public void game(){
        List<String> carNames = inputResolver.preprocessCarName();
        int count = inputResolver.preprocessCount();
        Game game = gameService.settingGame(carNames,count);

        racingGame(game);

        finishGame(game);

    }

    private void racingGame(Game game) {
        outputView.outputResultString();

        for (int i = 0; i < game.getCount(); i++) {
            List<GameResult> gameResults = gameService.startGame(game);
            outputView.outputGameResult(gameResults);
        }
    }

    private void finishGame(Game game) {
        List<String> winnerCarNameList = gameService.determineWinner(game);
        outputView.outputGameWinner(winnerCarNameList);
        Console.close();
    }
}
