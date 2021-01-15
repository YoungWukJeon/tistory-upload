package behavior_parameterization;

import static behavior_parameterization.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.color());
    }
}
