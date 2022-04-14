package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Ball;
import baseball.domain.Inning;
import baseball.domain.InningStatus;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InningTest {

    private Inning computer;

    @BeforeEach
    void setUp() {
        //given
        computer = new Inning(Arrays.asList(7, 2, 5));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,7", "1,2,2", "2,3,5"})
    @DisplayName("Integer List 로 들어온 값들이 제대로 만들어 졌는지 테스트")
    void 리스트로_볼_리스트_만들기(int comListIndex, int position, int number) {
        //when
        List<Ball> balls = computer.getBalls();
        //then
        assertThat(balls.get(comListIndex).equals(new Ball(position, number))).isTrue();

    }

    @ParameterizedTest
    @CsvSource(value = {"1,7,1,0", "2,7,0,1", "1,4,0,0"})
    @DisplayName("사용자 숫자 1개에 대한 판별")
    void 사용자_1개_비교_판별(int position, int number, int strikeCount, int ballCount) {
        //when
        InningStatus resultStatus = computer.compareOneBall(new Ball(position, number));
        //then
        assertThat(resultStatus.getStrike()).isEqualTo(strikeCount);
        assertThat(resultStatus.getBall()).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"7,2,5,3,0", "2,5,7,0,3", "7,5,3,1,1", "1,4,3,0,0"})
    @DisplayName("사용자 숫자 3개에 대한 판별")
    void 사용자_3개_비교_판별(int userNumber1, int userNumber2, int userNumber3, int strikeCount, int ballCount) {
        //when
        InningStatus resultStatus = computer.compareBalls(Arrays.asList(userNumber1, userNumber2, userNumber3));
        //then
        assertThat(resultStatus.getStrike()).isEqualTo(strikeCount);
        assertThat(resultStatus.getBall()).isEqualTo(ballCount);
    }

}
