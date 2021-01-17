package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        // stream
        // 1. 데이터를 담고 있는 저장소(컬렉션)가 아니다.
        // 2. Functional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않는다.
        // 3. 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
        // 4. 무제한일 수도 있다. (short circuit 메소드를 사용해서 제한할 수 있다.)
        // 5. 중개 오퍼레이션은 기본적으로 Lazy하다.
        // 6. 손쉽게 병럴 처리할 수 있다.

        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("guyko");
        names.add("toby");
        names.add("tester");

        // 2. stream에서 어떤 작업을 해도 names를 변경하지 않는다.
//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        names.forEach(System.out::println);

        // 중개 오퍼레이션 vs 종료 오퍼레이션
        // 중개 오퍼레이션은 stream을 리턴하고, 종료 오퍼레이션은 stream이 아닌 다른 타입을 리턴한다.
        // 중개 오퍼레이션의 종류 (filter, map, limit, skip, sorted ... )
        // 종료 오퍼레이션의 종류 (collect, allMatch, count, forEach, min, max ...)

        // 중개형 오퍼레이터는 실행하는게 아니다. 정의하는 것일 뿐
        // 실행해도 대문자로 바뀌지 않는다.
        names.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        });

        // 종료 오퍼레이션은 실행된다.
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 6. 손쉬운 병렬처리.
        // 6-1 : 스트림을 안쓰고 병럴 처리.
        for(String name : names) {
            if(name.startsWith("k")) {
                System.out.println(name.toUpperCase());
            }
        }
        // 6-2 : 스트림을 써서 처리.
        // parallelStream을 써서 병렬처리를 한다고 해서 빠른게 아니다. (데이터가 방대하게 큰 경우에 좋다.)
        names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
           return s.toUpperCase();
        });
        collect.forEach(System.out::println);
    }
}
