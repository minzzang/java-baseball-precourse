package baseball.controller;

import baseball.domain.Batter;
import baseball.domain.Innings;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.view.InningsResult;

public class Game {

    private Pitcher pitcher;
    private Referee referee;
    private Innings innings;

    private Game() {}

    public static Game create() {
        Game game = new Game();
        game.pitcher = new Pitcher();
        game.referee = new Referee();
        game.innings = new Innings();

        return game;
    }

    public void run() {
        pitcher.throwBall();
    }

    public void playBall(int[] batterBalls) {
        innings.init();

        Batter batter = new Batter();
        batter.hitBall(batterBalls);

        referee.referee(pitcher.getMultipleBalls(), batter.getMultipleBalls(), innings);
    }

    public boolean isEnded() {
        return referee.isEnded(innings);
    }

    public Innings getInnings() {
        return innings;
    }

    public InningsResult getInningsResult() {
        return InningsResult.of(innings);
    }
}
