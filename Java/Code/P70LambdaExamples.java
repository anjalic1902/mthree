import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class P70LambdaExamples {
    public static void main(String[] args) {
        // Basic lambda syntax
        Runnable runnable = () -> System.out.println("hello lambda!!!");
        runnable.run();

        // 2. Lambda with functional interface
        Predicate<String> isLong = s -> s.length() > 5;
        System.out.println(isLong.test("lambda"));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println("Number: " + n));

        Function<Integer, Integer> square = x -> x * x;
        numbers.stream().map(square).forEach(System.out::println);

        Function<Integer, Boolean> isEven = getIsEvenLambda();
        System.out.println(isEven.apply(4));
    }

    // Function to check if a number is even
    private static Function<Integer, Boolean> getIsEvenLambda() {
        return t -> t % 2 == 0;
    }
}
