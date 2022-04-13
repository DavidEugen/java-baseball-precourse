package baseball;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    private final List<Ball> balls;

    public Inning(List<Integer> numbers) {
        balls = makeBalls(numbers);
    }

    private List<Ball> makeBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 0;
        for (Integer number : numbers) {
            balls.add(new Ball(++position, number));
        }
        return balls;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public InningStatus compareOneBall(Ball oppositeBall) {
        InningStatus inningStatus = new InningStatus();
        for (Ball ball : balls) {
            BallStatus ballStatus = ball.compareBall(oppositeBall);
            inningStatus.record(ballStatus);
        }
        return inningStatus;
    }
}
