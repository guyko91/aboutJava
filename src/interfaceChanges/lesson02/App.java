package interfaceChanges.lesson02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        // 자바8에 추가된 기본 메서드들 (Iterable, Collection, Comparator)

        List<String> name = new ArrayList<>();
        name.add("test");
        name.add("test1");
        name.add("test2");
        name.add("test3");

        // 인자가 하나이므로 생략 가능.
        name.forEach(System.out::println);

        // iterator와 비슷한 기능. spliterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=======================");
        while (spliterator1.tryAdvance(System.out::println));

        // stream
        long count = name.stream().map(String::toUpperCase).filter(s -> s.endsWith("2")).count();

        // removeIf
        name.removeIf(s -> s.endsWith("2"));

        // sort + comparator
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        // 추가 정렬을 하고싶다면 reversed() 뒤에 thenComparing으로 쭉쭉 다음 정렬을 적용할 수 있다.
        name.sort(compareToIgnoreCase.reversed());
        // 그 외에
        // static reverseOrder() / naturalOrder()
        // static nullsFirst() / nullsLast() 등 많은 메서드가 추가되었다.

    }
}
