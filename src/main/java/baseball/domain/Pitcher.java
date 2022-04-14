package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.config.BaseballConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pitcher {

    public static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < BaseballConfig.NUMBER_SIZE) {
            int number = pickNumberInRange(BaseballConfig.MIN_NUMBER, BaseballConfig.MAX_NUMBER);
            numbers.add(number);
        }

        return new ArrayList<>(numbers);
    }
}
