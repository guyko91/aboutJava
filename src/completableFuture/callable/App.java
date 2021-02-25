package completableFuture.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    // Callable 과 Future
    // 1. Callable
    //  -> Runnable과 유사하지만 작업의 결과를 받을 수 있다.
    // 2. Future
    //  -> 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // functional 인터페이스로 구현.
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);

        System.out.println(helloFuture.isDone());
        System.out.println("Started! ");


        // helloFuture.get();   // 블록킹 call (결과를 기다림)
        helloFuture.cancel(true); // (true 는 interrupt 하면서 종료, false는 기다림)

        System.out.println(helloFuture.isDone());
        System.out.println("End!! ");

        executorService.shutdown();



        // invokeAll 과 invokeAny
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        Callable<String> hi = () -> {
            Thread.sleep(2000L);
            return "Hi";
        };
        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };
        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        // 1) invokeAll : 전체 다 종료될 때 까지 기다림.
//        List<Future<String>> futures = executorService1.invokeAll(Arrays.asList(hi, java, spring));
//        for(Future<String> f : futures) {
//            System.out.println(f.get());
//        }

        // 2) invokeAny : 하나가 종료되면 바로 리턴.
        String s = executorService1.invokeAny(Arrays.asList(hi, java, spring));
        System.out.println(s);

    }

}
