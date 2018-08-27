package com.rits.restfulwebservice.versioning;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 17/08/18
 */
public class PersonV2 {

    public Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
    public PersonV2() {
    }
    public PersonV2(Name name) {
        this.name = name;
    }
}
