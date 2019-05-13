package com.mista.petroz.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author mista */

@RestController
public class FilteringController {

    //Static Filter of field 1 and 3 in bean
    //Wont work with synamic filter defined in the somebean 
    @GetMapping(path="/filtering")
    public SomeBean getSomeBean(){
        return new SomeBean("1","2","3","4","5");
    }
    
    //Static Filter of field 1 and 3 in bean
    //Wont work with synamic filter defined in the somebean 
    @GetMapping(path="/filtering-list")
    public List<SomeBean> getAllSomeBeans(){
        return Arrays.asList(new SomeBean("1","2","3","4","5"),
                new SomeBean("11","22","33","44","55"));
    }
    
    //Only show field 2 and 5
    @GetMapping(path="/filtering-dynamic")
    public MappingJacksonValue getSomeBeanDynamic(){
        SomeBean someBean = new SomeBean("1","2","3","4","5");
        
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field5");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mapping.setFilters(filters);
        return mapping;
    }
    
    //Only show field 4 and 5
    @GetMapping(path="/filtering-dynamic-list")
    public MappingJacksonValue getAllSomeBeansDynamic(){
        List<SomeBean> list = Arrays.asList(new SomeBean("1","2","3","4","5"),
                new SomeBean("11","22","33","44","55"));
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field4","field5");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mapping.setFilters(filters);
        return mapping;
    }
}
