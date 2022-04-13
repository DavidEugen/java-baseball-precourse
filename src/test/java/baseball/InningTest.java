package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InningTest {

    private Inning computer;

    @BeforeEach
    void setUp() {
        //given
        computer = new Inning(Arrays.asList(7, 2, 5));
    }

    @Test
    @DisplayName("Integer List 로 들어온 값들이 제대로 만들어 졌는지 테스트")
    void 리스트로_볼_리스트_만들기(){
        //when
        List<Ball> balls = computer.getBalls();
        //then
        assertThat(balls.get(0).equals(new Ball(1, 7))).isTrue();
        assertThat(balls.get(1).equals(new Ball(2, 2))).isTrue();
        assertThat(balls.get(2).equals(new Ball(3, 5))).isTrue();
    }

    @Test
    @DisplayName("3개의 숫자를 받아서 공 한개와 비교")
    void 공_3개와_비교(){
        //when
        InningStatus resultStatus = computer.compareOneBall(new Ball(1, 7));
        //then
        assertThat(resultStatus.getStrike()).isEqualTo(1);
    }


}
