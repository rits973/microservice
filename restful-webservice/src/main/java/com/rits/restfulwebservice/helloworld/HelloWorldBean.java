package com.rits.restfulwebservice.helloworld;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 07/08/18
 */
public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
