package behavior_parameterization.quiz_1;

import behavior_parameterization.Apple;

import java.util.List;

public class QuizAnswer {
    public void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (final var apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }
}
