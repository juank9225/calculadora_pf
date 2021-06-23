import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtraction = (a, b) -> a - b;

        BiFunction<Integer, Integer, Integer> multiplication = (a, b) -> IntStream.range(0, b + 1)
                .reduce((accumulator, number) -> add.apply(accumulator, a)).getAsInt();

        BiFunction<Integer, Integer, Integer> division = (a, b) -> IntStream.range(0, a)
                .reduce((accumulator, number) -> multiplication.apply(number, b) <= a ? add.apply(accumulator, 1) : accumulator).getAsInt();


        System.out.println("__________ Calculadora con PF __________");
        System.out.println("suma: " + add.apply(8, 15));
        System.out.println("resta: " + subtraction.apply(5, 2));
        System.out.println("multiplicación: " + multiplication.apply(13, 22));
        System.out.println("division: " + division.apply(60, 4));

    }
}
