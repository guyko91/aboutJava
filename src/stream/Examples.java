package stream;

import java.util.ArrayList;
import java.util.List;

public class Examples {

    public static class OnlineClass {
        private Integer id;
        private String title;
        private boolean closed;

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
    }

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring으로 시작하는 수업");
        // TODO

        System.out.println("closed 되지 않은 수업");
        // TODO

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code Manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> guykoEvents = new ArrayList<>();
        guykoEvents.add(springClasses);
        guykoEvents.add(javaClasses);

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

    }

}
