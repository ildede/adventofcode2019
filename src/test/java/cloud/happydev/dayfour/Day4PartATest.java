package cloud.happydev.dayfour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day4PartATest {

    @Test
    void digits_111111_neverDecrease_true() {
        Assertions.assertTrue(
                Day4PartA.theDigitsNeverDecrease().test("111111")
        );
    }

    @Test
    void digits_123456_neverDecrease_true() {
        Assertions.assertTrue(
                Day4PartA.theDigitsNeverDecrease().test("123456")
        );
    }

    @Test
    void digits_135799_neverDecrease_true() {
        Assertions.assertTrue(
                Day4PartA.theDigitsNeverDecrease().test("135799")
        );
    }

    @Test
    void digits_123454_neverDecrease_false() {
        Assertions.assertFalse(
                Day4PartA.theDigitsNeverDecrease().test("123454")
        );
    }
}