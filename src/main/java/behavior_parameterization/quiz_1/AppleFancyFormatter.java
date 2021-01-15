package behavior_parameterization.quiz_1;

import behavior_parameterization.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.weight() > 200 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.color() + " apple";
    }
}
