package functionalProgramming.custom;

public class Foo {
    public static void main(String[] args) {

        // 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };

        // 위 코드를 람다 형식으로 변경.
        RunSomething runSomething1 = () -> System.out.println("Hello Lamda");
        runSomething1.doIt();
    }
}
