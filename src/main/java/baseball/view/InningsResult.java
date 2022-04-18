package baseball.view;

import baseball.domain.Innings;

import java.util.function.Consumer;

import static baseball.config.BaseBallConfig.BALL_SIZE;

public enum InningsResult {

    NOTHING(innings -> {
        System.out.println("낫싱");
    }),
    ALL(innings -> {
        System.out.println(innings.getStrikeCount() + "스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }),
    ONLY_BALL(innings -> {
        System.out.println(innings.getBallCount() + "볼");
    }),
    ONLY_STRIKE(innings -> {
        System.out.println(innings.getStrikeCount() + "스트라이크");
    }),
    BALL_AND_STRIKE(innings -> {
        System.out.println(innings.getBallCount() + "볼 " + innings.getStrikeCount() + "스트라이크");
    });

    private final Consumer<Innings> consumer;

    InningsResult(Consumer<Innings> consumer) {
        this.consumer = consumer;
    }

    public static InningsResult of(Innings innings) {
        int ballCount = innings.getBallCount();
        int strikeCount = innings.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) return NOTHING;

        if (ballCount == 0 && strikeCount == BALL_SIZE) return ALL;

        if (ballCount > 0 && strikeCount == 0) return ONLY_BALL;

        if (ballCount == 0 && strikeCount > 0) return ONLY_STRIKE;

        return BALL_AND_STRIKE;
    }

    public void show(Innings innings) {
        consumer.accept(innings);
    }
}
