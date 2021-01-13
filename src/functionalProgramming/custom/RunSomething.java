package functionalProgramming.custom;

@FunctionalInterface
public interface RunSomething {
    // 인터페이스에서는 abstract 키워드를 생략할 수 있다.
    void doIt();
    static void printName() {
        System.out.println("guyko");
    }
    default void printAge() {
        System.out.println("30");
    }

}
