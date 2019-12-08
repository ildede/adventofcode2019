package cloud.happydev.daythree;

import cloud.happydev.LineReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3PartA {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        List<String> lines = lineReader.getLines(Day3PartA.class.getResource("/day3input"));

        List<String> wire1instructions = Arrays.asList(lines.get(0).split(","));
        List<String> wire2instructions = Arrays.asList(lines.get(1).split(","));

        List<Point> points1 = getPointsOfPath(wire1instructions);
        List<Point> points2 = getPointsOfPath(wire2instructions);

        OptionalInt min = points1.stream()
                .filter(point -> !point.equals(new Point(0, 0)))
                .filter(points2::contains)
                .map(point -> Math.abs(point.x) + Math.abs(point.y))
                .mapToInt(l -> l)
                .min();

        System.out.println("collect = " + min.getAsInt());
    }

    private static List<Point> getPointsOfPath(List<String> wire1instructions) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        for (String s : wire1instructions) {
            int moves = Integer.parseInt(s.substring(1));
            if (s.startsWith("U")) {
                for (int i = 0; i < moves; i++) {
                    points.add(new Point(points.get(points.size()-1).x, points.get(points.size()-1).y+1));
                }
            }
            if (s.startsWith("D")) {
                for (int i = 0; i < moves; i++) {
                    points.add(new Point(points.get(points.size()-1).x, points.get(points.size()-1).y-1));
                }
            }
            if (s.startsWith("L")) {
                for (int i = 0; i < moves; i++) {
                    points.add(new Point(points.get(points.size()-1).x-1, points.get(points.size()-1).y));
                }
            }
            if (s.startsWith("R")) {
                for (int i = 0; i < moves; i++) {
                    points.add(new Point(points.get(points.size()-1).x+1, points.get(points.size()-1).y));
                }
            }
        }
        return points;
    }

    static final class Point {
        protected final Integer x;
        protected final Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Objects.equals(x, point.x) &&
                    Objects.equals(y, point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
