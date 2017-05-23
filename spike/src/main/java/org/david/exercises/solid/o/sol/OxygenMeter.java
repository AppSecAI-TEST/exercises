package org.david.exercises.solid.o.sol;

import org.david.exercises.solid.o.MeterStream;

/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenMeter {
    private MeterStream stream;
    private double oxygenSaturation;

    public OxygenMeter(MeterStream stream) {
        this.stream = stream;
    }

    public void readOxygenLevel() {
        int raw = stream.readByte();
        oxygenSaturation = (double) raw / 255 * 100;
    }

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }
}
