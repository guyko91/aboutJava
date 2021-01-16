package interfaceChanges.lesson01;

public interface Foo {

    void printName();

    // default 키워드를 통해 메소드를 제공할 수 있다.
    // 이 기능은 모든 인스턴스에 제공되는데, 항상 잘 작동할 것이란 보장은 없다.
    // 따라서 문서화를 잘 해주어야 한다.

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    };

    String getName();

    static void printAnyting() {
        System.out.println("anything");
    }
}
