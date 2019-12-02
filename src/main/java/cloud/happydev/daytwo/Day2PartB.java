package cloud.happydev.daytwo;

import cloud.happydev.LineReader;

import java.util.List;

public class Day2PartB {
    public static final int NOUN = 33;
    public static final int VERB = 76;

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();

        List<Integer> memory = lineReader.getIntcode(Day2PartB.class.getResource("/day2input"));

        memory.set(1, NOUN);
        memory.set(2, VERB);
        int instructionPointer = 0;
        int instruction = memory.get(instructionPointer);

        while (instruction != 99) {
            int firstParameter = memory.get(memory.get(instructionPointer+1));
            int secondParameter = memory.get(memory.get(instructionPointer+2));
            int thirdParameter = memory.get(instructionPointer+3);

            switch (instruction) {
                case 1:
                    memory.set(thirdParameter, firstParameter + secondParameter);
                    break;
                case 2:
                    memory.set(thirdParameter, firstParameter * secondParameter);
                    break;
                default:
                    throw new RuntimeException("Unknown instruction: " + instruction);
            }
            instructionPointer = instructionPointer + 4;
            instruction = memory.get(instructionPointer);
        }

        if (memory.get(0) == 19690720) {
            System.out.println("Solution day 2 part B");
            System.out.println("NOUN = " + NOUN + ", VERB = " + VERB);
        } else if (memory.get(0) > 19690720) {
            System.out.println("Wrong, too high: " + memory.get(0));
        } else {
            System.out.println("Wrong, too low: " + memory.get(0));
        }

    }

}
