package org.david.exercises.solid.i;

/**
 * Created by David Marques on 24/05/2017.
 */
public class Contact {

    private String name;
    private String address;
    private String emailAddress;
    private String telephone;

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Contact setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Contact setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}
