package behavior_parameterization.quiz_1;

import behavior_parameterization.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.weight() + "g";
    }
}
