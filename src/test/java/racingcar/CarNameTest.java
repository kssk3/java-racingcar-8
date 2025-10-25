package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void 이름이_5자_초과시_예외_발생() {
        String longName = "javaji";  // 6자

        assertThatThrownBy(() -> new CarName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 중복된_이름이_존재할경우_예외_발생() {
        CarNameValidator validator = new CarNameValidator();
        List<String> names = List.of("pobi", "jun", "pobi");

        assertThatThrownBy(() -> validator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다: " + "pobi");
    }


}
