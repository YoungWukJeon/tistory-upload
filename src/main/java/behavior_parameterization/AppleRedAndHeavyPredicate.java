package behavior_parameterization;

import static behavior_parameterization.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.color()) &&
                apple.weight() > 180;
    }
}
