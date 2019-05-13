package com.mista.petroz.limitsservice;

import com.mista.petroz.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author mista */
@RestController
public class LimitsConfigurartionController {

    @Autowired
    private Configuration configuration;
    
    @GetMapping
    public LimitConfiguration retrieveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMaximum(),
        configuration.getMinimum());
    }
}
