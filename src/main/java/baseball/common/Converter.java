package baseball.common;

import static baseball.config.BaseBallConfig.BALL_SIZE;

public class Converter {

    public static int[] toArray(String input) {
        int[] balls = new int[BALL_SIZE];

        for (int i = 0; i < BALL_SIZE; i++) {
            balls[i] = input.charAt(i) - '0';
        }
        return balls;
    }
}
