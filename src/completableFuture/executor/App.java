package completableFuture.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    // Executor : 고수준 Concurrency 프로그래밍.
    // 쓰레드를 만들고, 관리하는 작업을 애플리케이션에서 분리.
    // 그런 기능을 Executors 에게 위임.

    // Executor 가 하는일.
    // 1. 쓰레드 만들기 : 애플리케이션이 상요할 쓰레드 풀을 만들어 관리한다.
    // 2. 쓰레드 관리 : 쓰레드 생명 주기를 관리한다.
    // 3. 작업 처리 및 실행 : 쓰레드로 실행할 작업을 제공할 수 있는 API를 제공한다.

    // 주요 인터페이스
    // Executor.execute(Runnable)
    // ExecutorService : Executor 상속 받은 인터페이스로, Callable도 실행할 수 있으며, Executor를 종료 시키거나, 여러 Callable을 동시에 실행하는 등의 기능을 제공한다.
    // ScheduledExecutorService : ExecutorService를 상속 받은 인터페이스로 특정 시간 이후에 또는 주기적으로 작업을 실행할 수 있다.

    public static void main(String[] args) {

        // 1. ExecutorService 사용
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 1) runnable 직접 구현
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread : " + Thread.currentThread().getName());
//            }
//        });
        // 2) submit 메서드 사용.
        executorService.submit(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });

        // graceful shutdown : 작업을 다 마치고 종료시킴.
        executorService.shutdown();
        // 돌고있는 것과 상관없이 죽임 -> shutdownNow 메서드 사용.

        // 2. 쓰레드 개수 지정해서 생성할 수 있음.
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("Hello1"));
        executorService1.submit(getRunnable("Hello2"));
        executorService1.submit(getRunnable("Hello3"));
        executorService1.shutdown();

        // 3. Scheduled
        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
