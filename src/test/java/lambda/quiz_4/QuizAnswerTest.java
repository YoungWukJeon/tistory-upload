package lambda.quiz_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizAnswerTest {
    private final QuizAnswer quizAnswer = new QuizAnswer();

    @Test
    @DisplayName("생성자 참조를 이용한 색 생성 테스트")
    void createColorWithConstructorReferencesTest() {
        final var red = quizAnswer.newColor(255, 0, 0);
        assertEquals(new Color(255, 0, 0), red);
    }

}