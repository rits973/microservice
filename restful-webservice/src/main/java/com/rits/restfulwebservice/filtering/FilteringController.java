package com.rits.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 17/08/18
 */
@RestController
public class FilteringController {

    @GetMapping("/filtering-data")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean =  new SomeBean("value1","Value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
