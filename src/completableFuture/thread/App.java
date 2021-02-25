package completableFuture.thread;

public class App {

    public static void main(String[] args) throws InterruptedException {
        // 자바 Concurrent 프로그래밍
        // 1. Concurrent 소프트웨어
        //  - 동시에 여러 작업을 할 수 있는 소프트웨어.
        //  예) 웹 브라우저로 유튜브를 보면서 키보드로 문서에 타이핑을 할 수 있다.
        //  예2) 녹화를 하면서 인텔리J로 코딩을 하고 워드에 적어둔 문서를 보거나 수정할 수 있다.

        // 2. 자바에서 지원하는 Concurrent프로그래밍
        //  1) 멀티프로세싱
        //  2) 멀티쓰레드
        //  - 쓰레드 구현 방법
        //    1) Thread를 상속받아 직접 구현.
        //    2) Runnable을 구현. (functional interface)
        //    3) 람다를 사용.

        // 3. thread 활용법
        //  1) sleep : 강제로 thread를 sleep시킴.
        //  2) interrupt : sleep 되어있는 thread를 깨움.
        //  3) join : 다른 thread를 기다림.

        // 멀티 thread 프로그래밍은 2개이상부터 매우 복잡하다.

        Thread thread = new Thread(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            while(true) {
                try {
                    Thread.sleep(3000L);
                }catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread + " is finished");
    }

}
