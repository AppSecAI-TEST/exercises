package org.david.exercises.solid.s.sol;

import org.david.exercises.solid.s.MeterStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 23/05/2017.
 */
public class OxygenAlerterTest {

    @Mock
    private PrintStream printStream;

    @Captor
    ArgumentCaptor<String> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAlert() throws Exception {
        OxygenMeter meter = new OxygenMeter(new MeterStream("O2"));
        OxygenAlerter oxygenAlerter = new OxygenAlerter(meter, printStream);
        oxygenAlerter.showOxygenLevelAlert();
        Mockito.verify(printStream).println(captor.capture());
        assertThat(captor.getValue()).isEqualTo(String.format("Oxygen saturation level is: %s", meter.getOxygenSaturation()));
    }
}