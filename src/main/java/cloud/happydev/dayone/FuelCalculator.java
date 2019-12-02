package cloud.happydev.dayone;

public class FuelCalculator {
    public FuelCalculator() {
    }

    public Long getFuelCost(Long mass) {
        if (mass <= 0) {
            return 0L;
        } else {
            long l = Long.divideUnsigned(mass, 3L);
            long fuel = l - 2;
            if (fuel <= 0) {
                return 0L;
            } else {
                return fuel + this.getFuelCost(fuel);
            }

        }

    }
}