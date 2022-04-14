package baseball;

import java.util.ArrayList;
import java.util.List;

public class PlayGrounds {

    public  List<Integer> convertStringToNumbers(String givenValue) {
        List<Integer> numbers = new ArrayList<>();
        int givenValueLength = givenValue.length();
        for (int i = 0; i < givenValueLength; i++) {
            numbers.add(Integer.parseInt(String.valueOf(givenValue.charAt(i))));
        }
        return numbers;
    }
}
