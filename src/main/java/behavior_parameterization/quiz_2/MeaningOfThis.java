package behavior_parameterization.quiz_2;

public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        final var value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                final var value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
