package cloud.happydev.dayfour;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day4PartA {

    public static void main(String[] args) {

        long count = IntStream.range(153517, 630395)
                .mapToObj(String::valueOf)
                .filter(atLeastToDigitsAreTheSame())
                .filter(theDigitsNeverDecrease())
                .count();

        System.out.println("count = " + count);
    }

    protected static Predicate<String> theDigitsNeverDecrease() {
        return n -> {
            for (int i = 0; i < 5; i++) {
                if (n.charAt(i) > n.charAt(i+1)) {
                    return false;
                }
            }
            return true;
        };
    }

    protected static Predicate<String> atLeastToDigitsAreTheSame() {
        return n -> {
            for (int i = 0; i < 5; i++) {
                if (n.charAt(i) == n.charAt(i+1)) {
                    return true;
                }
            }
            return false;
        };
    }

}
