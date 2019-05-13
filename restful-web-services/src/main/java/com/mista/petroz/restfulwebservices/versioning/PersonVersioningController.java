package com.mista.petroz.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author mista */

@RestController
public class PersonVersioningController {

    //Versioning using url
    @GetMapping(path="v1/person")
    public PersonV1 personV1(){
        return new PersonV1("John Doe");
    }
    
    @GetMapping(path="v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("John","Doe"));
    }
    
    //Vesioning using params
    @GetMapping(path="/person/params", params="version=1")
    public PersonV1 paramV1(){
        return new PersonV1("John Doe");
    }
    
    @GetMapping(path="/person/params", params="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("John","Doe"));
    }
    
    //Vesioning using headers
    @GetMapping(path="/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("John Doe");
    }
    
    @GetMapping(path="/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("John","Doe"));
    }
 
    //Vesioning using AcceptHeader Versioning/
    @GetMapping(path="/person/produces", produces="application/www.mistapetroz.com-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("John Doe");
    }
    
    @GetMapping(path="/person/produces", produces="application/www.mistapetroz.com-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("John","Doe"));
    }
}
