package org.david.exercises.solid.s.sol;


import org.david.exercises.solid.s.MeterStream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenMeterTest {

    @Test
    public void testOxygenMeterWithDefaultMeterStreamData() throws Exception {
        OxygenMeter om = new OxygenMeter(new MeterStream("02"));
        om.readOxygenLevel();
        assertThat(om.getOxygenSaturation()).isEqualTo(getSaturationFromRawData(MeterStream.DEFAULT_DATA));
    }

    @Test
    public void testOxygenMeterWithInjectedMeterStreamData() throws Exception {
        MeterStream stream = new MeterStream("02");
        stream.setMockData((byte) 0x30);
        OxygenMeter om = new OxygenMeter(stream);
        om.readOxygenLevel();
        assertThat(om.getOxygenSaturation()).isEqualTo(getSaturationFromRawData((byte) 0x30));
    }

    private double getSaturationFromRawData(byte raw) {
        return (double) raw / 255 * 100;
    }
}