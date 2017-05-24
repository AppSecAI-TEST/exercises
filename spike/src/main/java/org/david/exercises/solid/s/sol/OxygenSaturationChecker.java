package org.david.exercises.solid.s.sol;

/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenSaturationChecker {
    private OxygenMeter meter;

    public OxygenSaturationChecker(OxygenMeter meter) {
        this.meter = meter;
    }

    public boolean isOxygenLow() {
        return meter.getOxygenSaturation() <= 75;
    }
}
