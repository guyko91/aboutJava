package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {

    public static void main(String[] args) {
        List<App.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new App.OnlineClass(2, "spring boot", true));
        springClasses.add(new App.OnlineClass(2, "spring data jpa", true));
        springClasses.add(new App.OnlineClass(3, "spring mvc", false));
        springClasses.add(new App.OnlineClass(4, "spring core", false));
        springClasses.add(new App.OnlineClass(5, "rest api development", false));

        Optional<App.OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();


        // Optional인터페이스가 제공하는 메서드
        // 1. ifPresent : 값이 있는 경우에 그 값을 가지고 ~~ 하라.
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 2. orElse : 값이 있으면 가져오고, 없는 경우에 ~~를 리턴하라.
        // 있어도 수행된다.
        //App.OnlineClass onlineClass = optional.orElse(createNewClass());

        // 3. orElseGet : 값이 있으면 가져오고, 없는 경우에 ~~를 하라.
        // 없을때만 수행된다.
        App.OnlineClass onlineClass1 = optional.orElseGet(App2::createNewClass);

        // 4. orElseThrow : 값이 있으면 가져오고, 없는 경우 에러를 던져라.
        App.OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new);

        // Optional 안의 값 걸러내기
        // 5. filter : 인자로 Predicate
        Optional<App.OnlineClass> onlineClass = optional.filter(oc -> !oc.isClosed());

        // Optional 들어있는 값 변환하기
        // 6. map / flatMap (Optional 안에 있는 인스턴스가 Optional인 경우에 사용하면 편리)
        Optional<Integer> integer = optional.map(App.OnlineClass::getId);
    }

    private static App.OnlineClass createNewClass() {
        System.out.println("New Class  Created");
        return new App.OnlineClass(10, "New Class", false);
    }
}
