package optional;

import stream.Examples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {

    public static class OnlineClass {
        private Integer id;
        private String title;
        private boolean closed;
        private Progress progress;

        public OnlineClass(Integer id, String title, boolean closed) {
            this.id = id;
            this.title = title;
            this.closed = closed;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }

        // Optional로 리턴타입을 감싸면,
        public Optional<Progress> getProgress() {
            // of를 사용하기 위해서는 인자가 null이 아니어야 한다.
            // return Optional.of(progress);
            return Optional.ofNullable(progress);
        }

        public void setProgress(Progress progress) {
            this.progress = progress;
        }
    }
    public static class Progress {
        private Duration duration;
        private boolean finished;
        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }
    }

    public static void main(String[] args) {

        // 자바 프로그밍에서 NullPointerException을 종종 보게 되는 이유.
        // null을 리턴하니까! && null 체크를 깜빡했으니까!

        // 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 경우 선택할 수 있는 방법.
        // 1. 예외를 던진다. (비싸다, 스텍트레이스를 찍어두니까)
        // 2. null을 리턴한다. (비용 문제가 없지만 그 코드를 사용하는 클라이언트 코드에서 주의가 필요하다.)
        // 3. Optional을 리턴한다. (클라이언트에 명시적으로 빈값일 수도 있다는 걸 알려주고, 빈 값인 경우에 대한 처리를 강제한다.)

        // Optional
        // -> 오직 값 한개 또는 없을 수 도 있는 컨테이너.

        // 주의사항
        // 1. 리턴값으로만 쓰기를 권장. (메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지 말자.)
        // 2. Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
        // 3. 프리미티브 타입용 Optional은 따로 있다. (OptionalInt, OptionalLong 등등)
        // 4. Collection, Map, Stream Array, Optional은 Optional로 감싸지 말것. (Optional로 감싸면 굳이 두번 감싸는 것 과 같음)

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(2, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        // 1. 매번 null 체크를 할 수 없다.
        // 2. null을 리턴하는 것 자체가 문제다.
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p -> System.out.println(p.getDuration()));


    }



}
