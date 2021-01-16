package behavior_parameterization.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunnableTest {
    @Test
    @DisplayName("익명 클래스를 이용한 실행")
    void runnableUsingAnonymousClassTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        thread.start();
    }

    @Test
    @DisplayName("람다를 이용한 실행")
    void runnableUsingLambdaTest() {
        Thread thread = new Thread(() -> System.out.println("Hello World"));
        thread.start();
    }
}
