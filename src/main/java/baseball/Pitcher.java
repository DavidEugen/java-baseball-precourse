package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pitcher {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_SIZE = 3;

    public List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < NUMBER_SIZE) {
            int number = pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            numbers.add(number);
        }

        return new ArrayList<>(numbers);
    }
}
