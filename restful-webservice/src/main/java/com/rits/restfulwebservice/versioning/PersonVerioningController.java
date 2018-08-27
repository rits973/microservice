package com.rits.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 17/08/18
 */
@RestController
public class PersonVerioningController {

    @GetMapping(value = "/person/param",params = "version=1")
    public PersonV1 personV1(){
        return new PersonV1("Ritesh");
    }
    @GetMapping(value = "/person/param",params = "version=2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Ritesh","Singh"));
    }
}
