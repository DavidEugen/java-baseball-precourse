package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayGrounds {

    public static List<Integer> convertStringToNumbers(String givenValue) {
        List<Integer> numbers = new ArrayList<>();
        int givenValueLength = givenValue.length();
        for (int i = 0; i < givenValueLength; i++) {
            numbers.add(Integer.parseInt(String.valueOf(givenValue.charAt(i))));
        }
        return numbers;
    }

    public void playGame() {
        String inputValue;
        do {
            playInning();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            inputValue = Console.readLine();
        } while (!inputValue.equals("2"));
        System.out.println("게임 종료");

    }

    private void playInning() {
        Inning inning = new Inning(Pitcher.generateNumbers());
        InningStatus inningStatus;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inningStatus = inningProcess(inning);
        } while (inningStatus.continueInning());

    }

    private InningStatus inningProcess(Inning inning) {
        InningStatus inningStatus;
        inningStatus = inning.compareBalls(convertStringToNumbers(readLine()));
        System.out.println(getStatusMessage(inningStatus));
        return inningStatus;
    }

    private String getStatusMessage(InningStatus inningStatus) {
        if (!inningStatus.continueInning()) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (inningStatus.getBall() == 0 && inningStatus.getStrike() == 0) {
            return "낫싱";
        }

        StringBuilder statusMessage = new StringBuilder();
        if (inningStatus.getBall() != 0) {
            statusMessage.append(inningStatus.getBall()).append(" 볼 ");
        }
        if (inningStatus.getStrike() != 0) {
            statusMessage.append(inningStatus.getStrike()).append(" 스트라이크");
        }

        return statusMessage.toString();
    }
}
