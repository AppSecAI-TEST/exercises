package org.david.exercises.solid.i.sol;

import org.junit.Test;

/**
 * Created by David Marques on 24/05/2017.
 */
public class DiallerTest {

    @Test
    public void testDiallFromContact() throws Exception {
        Contact c = new Contact().setName("Hello").setAddress("Random");
        c.setPhone("9999999999");
        c.setEmailAddress("hello@j.com");
        Dialler dialler = new Dialler();
        dialler.makeCall(c);
    }

    @Test
    public void testDiallFromMobileEngineer() throws Exception {
        MobileEngineer mobileEngineer = new MobileEngineer().setVehicle("BMW");
        mobileEngineer.setPhone("99999999");
        Dialler d = new Dialler();
        d.makeCall(mobileEngineer);
    }
}