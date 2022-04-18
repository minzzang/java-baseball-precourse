package baseball.view;

import baseball.common.Converter;
import baseball.controller.Game;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public static void start() {
        Game game = Game.create();
        game.run();

        while (!game.isEnded()) {
            String input = ConsoleView.inputNumber();
            int[] balls = Converter.toArray(input);

            game.playBall(balls);
            ConsoleView.showResult(game);
        }

        ConsoleView.gameOver();
    }

    public static void showResult(Game game) {
        InningsResult result = game.getInningsResult();
        result.show(game.getInnings());
    }

    public static void gameOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = inputGameOver();

        GameCommand command = GameCommand.of(num);
        command.command();
    }

    private static int inputGameOver() {
        String input = Console.readLine();

        return InputValidator.validateNumber(input);
    }

    public static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        InputValidator.validate(input);

        return input;
    }

}
