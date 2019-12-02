public class Day1PartB {

    private static FuelCalculator fuelCalculator = new FuelCalculator();
    private static LineReader lineReader = new LineReader();

    public static void main(String[] args) {

        long collect = lineReader
                .getLines(Day1PartB.class.getResource("day1input"))
                .stream()
                .mapToLong(Long::valueOf)
                .map(l -> fuelCalculator.getFuelCost(l))
                .sum();
        System.out.println("Solution part B: " + collect);
    }
}
