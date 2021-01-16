package interfaceChanges.lesson01;

public class Default implements Foo {

    String name;

    public Default(String name) {
        this.name = name;
    }

    // 인터페이스에 있는 default 메서드를 구현 클래스에서 구현할 수 있다.
    // BUT equals() 나 hashCode toString 같은 것은 재정의할 수 없다.
    @Override
    public void printNameUpperCase() {

    }
    // Foo를 구현해서 이미 default메서드를 구현해놓고 있는데 Bar2도


    @Override
    public void printName() {
        System.out.println("Default Foo");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
