package cloud.happydev.daytwo;

import cloud.happydev.LineReader;

import java.util.List;

public class Day2PartA {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        List<Integer> intcode = lineReader.getIntcode(Day2PartA.class.getResource("/day2input"));
        System.out.println("intcode = " + intcode);
        System.out.println("Solution day 2 part A: N.D.");
    }

}
