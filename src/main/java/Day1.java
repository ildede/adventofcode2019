public class Day1 {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        long collect = lineReader
                .getLines(Day1.class.getResource("day1inputA"))
                .stream()
                .mapToLong(Long::valueOf)
                .map(l -> Long.divideUnsigned(l, 3L))
                .map(l -> l - 2L)
                .sum();
        System.out.println("Solution part A: " + collect);
    }
}
