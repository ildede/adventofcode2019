package cloud.happydev.dayfour;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day4PartB {

    public static void main(String[] args) {

        long count = IntStream.range(153517, 630395)
                .mapToObj(String::valueOf)
                .filter(theDigitsNeverDecrease())
                .filter(atLeastTwoDigitsAreTheSame())
                .filter(twoEqualsDigitsAreNotPartOfLargerGroup())
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

    protected static Predicate<String> atLeastTwoDigitsAreTheSame() {
        return n -> {
            for (int i = 0; i < 5; i++) {
                if (n.charAt(i) == n.charAt(i+1)) {
                    return true;
                }
            }
            return false;
        };
    }

    protected static Predicate<String> twoEqualsDigitsAreNotPartOfLargerGroup() {
        return n -> {
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            char[] strArray = n.toCharArray();
            for (char c : strArray) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 1);
                }
            }
            return charCountMap.values()
                    .stream()
                    .anyMatch(count -> count == 2);
        };
    }

}
