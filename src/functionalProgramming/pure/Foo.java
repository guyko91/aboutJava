package functionalProgramming.pure;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {

        // oracle function API문서.
        // https://bit.ly/3iawMfm

        // 1. Function
        // functional 을 구현한 구현클래스의 인스턴스를 생성하여 이용하는 CASE.
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(11));

        // 람다 표현식을 활용하여 표기.
        Function<Integer, Integer> newPlus10 = (i) -> {
            return i + 10;
        };
        System.out.println(newPlus10.apply(10));
        Function<Integer, Integer> multiply2 = (i) -> {
            return i * 2;
        };
        System.out.println(multiply2.apply(10));

        // 함수 조합 (newPlus10과 multiply2를 조합)
        // 1. compose : 인자로 넘긴 함수를 앞에 붙임.
        // multiply2를 수행한 값을 newPlus10의 인자로 넘김.
        Function<Integer, Integer> multiply2AndPlus10 = newPlus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(10));

        // 2. andThen : 인자로 넘긴 함수를 뒤에 붙임.
        System.out.println(newPlus10.andThen(multiply2).apply(10));


        // BiFunction
        // function과 다르게 인자가 2개.
        // 입력받는 인자의 형태가 다 다를 것을 염두한 인터페이스
        BiFunction<Integer, Integer, Integer> biFunc = Integer::sum;
        System.out.println(biFunc.apply(1,2));

        // Consumer
        // T라는 타입을 받아서 아무것도 리턴하지 않음.
        // 함수 조합용 메서드 anThen을 제공.
        Consumer<Integer> printT = (i) -> {
            System.out.println(i);
        };

        // Supplier<T>
        // T 타입의 값을 제공하는 함수 인터페이스
        // 함수를 통해 받아올 값의 타입을 정의한다.
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predict<T>
        // 어떤 인자 값을 받아서 true / false를 리턴해주는 함수 인터페이스.
        Predicate<String> startsWithABC = (s) -> s.startsWith("ABC");

        // UnaryOperator<T>
        // 입력값이 하나이고, 입력 값과 리턴 값의 타입이 같은 경우, UnaryOperator를 사용할 수 있다.
        // Function을 상속받기 때문에 compose나 andThen을 사용할 수 있다.
        Function<Integer, Integer> before = (s) -> {
            return s + 10;
        };
        UnaryOperator<Integer> after = (s) -> {
            return s + 10;
        };

        // BinaryOperator<T>
        // BiFunction을 상속받은 인터페이스
        //
        BinaryOperator<Integer> binaryOp = (i, j) -> {
            return i * j;
        };
    }
}
