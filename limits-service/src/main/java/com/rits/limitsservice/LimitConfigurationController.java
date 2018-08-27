package com.rits.limitsservice;

import com.rits.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 22/08/18
 */
@RestController
public class LimitConfigurationController {

    @Autowired
    Configuration  configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());

    }
}
