package com.mista.petroz.restfulwebservices.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
 
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
    
    @GetMapping(path="/hello-world/path-variable/{action}/{name} v/{value}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String action, @PathVariable String name, @PathVariable int value){
        return new HelloWorldBean(String.format("Hello World, %s : %s : %d", action, name, value));
    }

    @GetMapping(path="/hello-world-international")
    public String helloWorldInternational(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
    
}
