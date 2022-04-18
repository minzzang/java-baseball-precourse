package baseball.view;

import java.util.HashMap;
import java.util.Map;

public enum GameCommand {

    START(1, (
        ConsoleView::start
    ))
    , GAME_OVER(2, (() -> {})
    );

    static Map<Integer, GameCommand> COMMAND_MAP = new HashMap<>();
    static {
        for (GameCommand command : values()) {
            COMMAND_MAP.put(command.value, command);
        }
    }

    private final int value;
    private final Command command;

    GameCommand(int value, Command command) {
        this.value = value;
        this.command = command;
    }

    public void command() {
        this.command.command();
    }

    public static GameCommand of(int value) {
        GameCommand command = COMMAND_MAP.get(value);
        if (command == null) {
            throw new IllegalArgumentException("올바른 번호를 입력해주세요. 재시작 : 1, 종료 : 2");
        }

        return command;
    }
}
