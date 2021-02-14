package lambda.quiz_4;

public class QuizAnswer {
    public Color newColor(int red, int green, int blue) {
        TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;
        return colorFactory.apply(red, green, blue);
    }
}
