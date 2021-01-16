package interfaceChanges.lesson01;

public interface Bar2 {

    default void printNameUpperCase() {
        System.out.println("Bar2");
    };

}
