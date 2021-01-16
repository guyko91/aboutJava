package interfaceChanges.lesson01;

public interface Bar extends Foo {

    // Foo를 상속받았으나, Foo에 있는 디폴트 함수를 사용하고 싶지 않으면, 아래처럼 재선언 해주면 된다.
//    void printNameUpperCase();

}
