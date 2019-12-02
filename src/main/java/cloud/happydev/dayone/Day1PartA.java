package cloud.happydev.dayone;

import cloud.happydev.LineReader;

public class Day1PartA {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        long collect = lineReader
                .getLines(Day1PartA.class.getResource("/day1input"))
                .stream()
                .mapToLong(Long::valueOf)
                .map(l -> Long.divideUnsigned(l, 3L))
                .map(l -> l - 2L)
                .sum();
        System.out.println("Solution day 1 part A: " + collect);
    }
}
