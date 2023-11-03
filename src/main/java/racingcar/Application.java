package racingcar;

import racingcar.controller.GameController;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new GameService(new CarService())
                , new InputValidator()
        );

        gameController.game();
    }
}
