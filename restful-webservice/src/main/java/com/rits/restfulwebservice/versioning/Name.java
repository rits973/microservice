package com.rits.restfulwebservice.versioning;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 17/08/18
 */
public class Name {

    public String firstName;

    public String lastname;

    public Name() {

    }
    public Name(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
