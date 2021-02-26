package completableFuture.completableFuture;

public class App {

    // Completable Future
    // 자바에서 비동기(Asynchronous) 프로그래밍을 가능케 하는 인터페이스.
    // Future를 활용하여 어느정도 가능했지만, 하기 힘들 일들이 많았다.
    //  - Future를 외부에서 완료 시킬 수 없다. 취소하거나, get()에 타임아웃을 설정할 수는 있다.
    //  - 블로킹 코드(get())를 사용하지 않고서는 작업이 끝났을 때, 콜백을 실행할 수 없다.
    //  - 여러 Future를 조합할 수 없다. 예) Event 정보 가져온 다음 Event에 참석하는 회원 목록 가져오기.
    //  - 예외 처리용 API를 제공하지 않는다.

    public static void main(String[] args) {
        
    }
}
