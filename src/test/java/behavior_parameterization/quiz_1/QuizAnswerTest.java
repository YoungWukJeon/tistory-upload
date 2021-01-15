package behavior_parameterization.quiz_1;

import behavior_parameterization.Apple;
import behavior_parameterization.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuizAnswerTest {
    private final QuizAnswer quizAnswer = new QuizAnswer();
    private final List<Apple> inventory = List.of(
            new Apple(Color.GREEN, 200),
            new Apple(Color.GREEN, 220),
            new Apple(Color.RED, 180),
            new Apple(Color.GREEN, 200),
            new Apple(Color.RED, 190));

    @Test
    @DisplayName("AppleFancyFormatter를 이용한 사과 출력")
    void prettyPrintAppleWithAppleFancyFormatter() {
        quizAnswer.prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    @Test
    @DisplayName("AppleSimpleFormatter를 이용한 사과 출력")
    void prettyPrintAppleWithAppleSimpleFormatter() {
        quizAnswer.prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}