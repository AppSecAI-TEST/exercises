package org.david.exercises.solid.s.sol;

import java.io.PrintStream;

/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenAlerter {

    private final PrintStream output;
    private final OxygenMeter meter;

    public OxygenAlerter(OxygenMeter meter, PrintStream output) {
        this.output = output;
        this.meter = meter;
    }

    public void showOxygenLevelAlert() {
        output.println(String.format("Oxygen saturation level is: %s", meter.getOxygenSaturation()));
    }
}
