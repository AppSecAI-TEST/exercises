package org.david.exercises.solid.i.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public class Contact implements IEmailable, IDiallable {
    private String name;
    private String emailAddress;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public IEmailable setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public String phone() {
        return phone;
    }

    @Override
    public IDiallable setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }
}
