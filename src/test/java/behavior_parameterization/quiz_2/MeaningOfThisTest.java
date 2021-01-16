package behavior_parameterization.quiz_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeaningOfThisTest {
    private final MeaningOfThis meaningOfThis = new MeaningOfThis();

    @Test
    @DisplayName("익명 클래스 문제")
    void anonymousClassTest() {
        meaningOfThis.doIt();
    }
}