package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    @ParameterizedTest
    @DisplayName("1~9까지 유효 범위 내의 숫자 인지 테스트")
    @CsvSource(value = {"-1,false", "0,false", "1,true", "9,true", "10,false"})
    void 숫자_생성_검증(int inputNumber, boolean expected) {
        //when
        boolean rightNumber = Ball.isInRangeNumber(inputNumber);
        //then
        assertThat(rightNumber).isEqualTo(expected);
    }

    @Test
    @DisplayName("스트라이크 여부 테스트")
    void 스트라이크_여부_테스트(){
        //given
        Ball computer = new Ball(1, 3);
        //when
        String result = computer.compareBall(new Ball(1, 3));
        //then
        assertThat(result).isEqualTo("Strike");
    }

}
