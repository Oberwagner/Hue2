import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Java");

        list.forEach((String s) -> System.out.println(s));

        list.forEach(System.out::println);
    }
}
