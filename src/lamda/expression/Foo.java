package lamda.expression;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {
    public static void main(String[] args) {

        // 람다 표현식
        // 괄호 안은 함수에 넘길 인자
        // 화살표 우측은 함수 Body
        // Body가 한줄일 경우, 중괄호를 생략할 수 있다.
        Supplier<Integer> get10 = () -> 10;

    }

    // 변수 캡쳐 기
    private void run() {
        // final을 생략 가능한 경우 : scope내에서 해당 변수를 변경하지 않는 경우.
        // effective final : scope내에서 해당변수를 변경하는 부분이 없음.
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        // 로컬 클래스 및 익명 클래스와 람다가 다른 점.
        // 로컬 클래스 및 익명 클래스는 셰도잉이 된다.
        // 람다는 셰도잉이 일어나지 않는다. (람다는 람다를 감싸고 있는 부분과 같은 scope이기 때문에.
        // 셰도잉 : scope 내 상위 scope의 변수와 같은 변수가 있으면 상위 scope의 변수를 가리게 되는 점.
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
