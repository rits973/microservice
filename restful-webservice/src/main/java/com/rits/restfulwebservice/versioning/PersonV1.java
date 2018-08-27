package com.rits.restfulwebservice.versioning;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 17/08/18
 */
public class PersonV1 {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public PersonV1( ) {
    }
    public PersonV1(String name) {
        this.name = name;
    }
}
