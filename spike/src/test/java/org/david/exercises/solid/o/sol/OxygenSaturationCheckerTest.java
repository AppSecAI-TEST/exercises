package org.david.exercises.solid.o.sol;


import org.david.exercises.solid.o.MeterStream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenSaturationCheckerTest {

    @Test
    public void testLowSaturationLevel() throws Exception {
        OxygenMeter meter = new OxygenMeter(new MeterStream("02"));
        OxygenSaturationChecker saturationChecker = new OxygenSaturationChecker(meter);
        meter.setOxygenSaturation(0x0);
        assertThat(saturationChecker.isOxygenLow()).isTrue();
    }

    @Test
    public void testNonLowSaturationLevel() throws Exception {
        OxygenMeter meter = new OxygenMeter(new MeterStream("02"));
        OxygenSaturationChecker saturationChecker = new OxygenSaturationChecker(meter);
        meter.setOxygenSaturation(0x100);
        assertThat(saturationChecker.isOxygenLow()).isFalse();
    }
}