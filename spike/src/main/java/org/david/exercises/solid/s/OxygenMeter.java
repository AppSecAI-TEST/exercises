package org.david.exercises.solid.s;

/**
 * Created by David Marques on 23/05/2017.
 * Before refactoring
 */
public class OxygenMeter {
    private double oxygenSaturation;

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double oxygenSaturation) {
        oxygenSaturation = oxygenSaturation;
    }

    private boolean isOxygenLow() {
        return oxygenSaturation <= 75; // more than on responsibility ??
    }

    public void showOxygenLevelAlert() { // more than on responsibility ??
        System.out.println(String.format("Oxygen Level : %1", oxygenSaturation));
    }

    public void readOxygenLevel() {
        MeterStream stream = new MeterStream("O2"); // hidden dependency ?
        int raw = stream.readByte();
        oxygenSaturation = (double) raw / 255 * 100;
    }
}
