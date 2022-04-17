package baseball.domain.game;

public class Innings {

    private int strikeCount;
    private int ballCount;

    public void strike() {
        strikeCount++;
    }

    public void ball() {
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
