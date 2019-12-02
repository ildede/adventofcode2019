import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuelCalculatorTest {

    public static final FuelCalculator FUEL_CALCULATOR = new FuelCalculator();

    @Test
    void getFuelCostOf12() {
        Long fuelCost = FUEL_CALCULATOR.getFuelCost(12L);
        assertEquals(2L, fuelCost);
    }
    @Test
    void getFuelCostOf14() {
        Long fuelCost = FUEL_CALCULATOR.getFuelCost(14L);
        assertEquals(2L, fuelCost);
    }
}