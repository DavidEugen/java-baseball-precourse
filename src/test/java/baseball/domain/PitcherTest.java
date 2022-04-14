package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Pitcher;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PitcherTest {

    @Test
    @DisplayName("중복 없는 3자리 숫자 생성 테스트")
    void 중복없는_3자리_숫자_생성_테스트() {
        //given
        Pitcher pitcher = new Pitcher();
        //when
        List<Integer> numbers = pitcher.generateNumbers();
        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(new HashSet<>(numbers).size()).isEqualTo(3);
    }

}
