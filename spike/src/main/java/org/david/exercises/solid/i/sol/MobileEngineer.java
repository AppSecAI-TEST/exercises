package org.david.exercises.solid.i.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public class MobileEngineer implements IDiallable {
    private String phone;
    private String vehicle;

    @Override
    public String phone() {
        return phone;
    }

    @Override
    public IDiallable setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getVehicle() {
        return vehicle;
    }

    public MobileEngineer setVehicle(String vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}
