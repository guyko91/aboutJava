package lamda.methodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {
    public static void main(String[] args) {

        // 메서드 레퍼런스 사용법

        // 1. 스태틱 메서드 참조
        //   -> 콜론 두개로 특정 메서드의 static 메서드를 통해 구현하는 방법.
        // As - Is
        UnaryOperator<String> hi = (s) -> "hi " + s;
        // To - Be
        UnaryOperator<String> hi2 = Greeting::hi;

        // 2. 인스턴스의 메서드를 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> h3 = greeting::hello;

        // 3. 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new; // 이렇게 했다고 해서 객체를 만든게 아니다.
        Greeting greeting2 = newGreeting.get(); // .get()을 해야 인스턴스를 생성한 것이다.
        UnaryOperator<String> h4 = greeting2::hello;
        // 문자열을 받는 생성자롤 사용
        Function<String, Greeting> newGreeting2 = Greeting::new;
        // 인자가 없는 생성자를 사용
        Supplier<Greeting> newGreeting3 = Greeting::new;

        // 4. 임의의 객체의 인스턴스 메소드를 참조
        String[] names = {"guyko3", "guyko1", "guyko2"};
        // Comparator가 자바8 부터는 FunctionalInterface가 됨.
        // type 1
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        // type 2
//        Arrays.sort(names, (o1, o2) -> 0);
        // type 3
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
