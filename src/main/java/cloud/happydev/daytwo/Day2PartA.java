package cloud.happydev.daytwo;

import cloud.happydev.LineReader;

import java.util.List;

public class Day2PartA {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        List<Integer> intcode = lineReader.getIntcode(Day2PartA.class.getResource("/day2input"));

        intcode.set(1, 12);
        intcode.set(2, 2);
        int opcodePointer = 0;
        int opcode = intcode.get(opcodePointer);

        while (opcode != 99) {
            int first = intcode.get(intcode.get(opcodePointer+1));
            int second = intcode.get(intcode.get(opcodePointer+2));
            int resultPointer = intcode.get(opcodePointer+3);

            switch (opcode) {
                case 1:
                    intcode.set(resultPointer, first + second);
                    break;
                case 2:
                    intcode.set(resultPointer, first * second);
                    break;
                default:
                    throw new RuntimeException("Unknown opcode: " + opcode);
            }
            opcodePointer = opcodePointer + 4;
            opcode = intcode.get(opcodePointer);
        }

        System.out.println("Solution day 2 part A: " + intcode.get(0));
    }

}
