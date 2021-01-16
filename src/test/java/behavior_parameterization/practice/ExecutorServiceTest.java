package behavior_parameterization.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    @Test
    @DisplayName("익명 클래스를 이용한 서비스 실행")
    void executorServiceUsingAnonymousClassTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        System.out.println(threadName.get());
    }

    @Test
    @DisplayName("람다를 이용한 서비스 실행")
    void executorServiceUsingLambdaTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println(threadName.get());
    }
}
