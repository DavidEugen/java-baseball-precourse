package baseball;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    List<Ball> balls = new ArrayList<>();

    public Inning(List<Integer> numbers) {
        int position = 0;
        for (Integer number : numbers) {
            balls.add(new Ball(++position, number));
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
