package com.mista.petroz.restfulwebservices.versioning;

/** @author mista */

public class PersonV1 {

    private String name;

    public PersonV1() {
    }

    public PersonV1(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
