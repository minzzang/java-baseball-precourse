package baseball.domain.ball;

import java.util.*;

import static baseball.config.BaseBallConfig.BALL_SIZE;

public class MultipleBalls {

    private List<Integer> ball = new ArrayList<>();

    public boolean isCompleted() {
        return this.ball.size() == BALL_SIZE;
    }

    public void addBall(int ball) {
        if (isCompleted()) {
            throw new IllegalStateException(BALL_SIZE + "보다 많은 볼을 추가할 수 없습니다.");
        }
        if (this.ball.contains(ball)) {
            return;
        }
        this.ball.add(ball);
    }

    public int findByIndex(int index) {
        if (index < 0 || ball.size() <= index) {
            throw new IllegalArgumentException("잘못된 인덱스 범위입니다.");
        }
        return this.ball.get(index);
    }

    public boolean contains(int batterNumber) {
        return this.ball.contains(batterNumber);
    }
}
