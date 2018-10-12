package com.scalefocus.tibco.camel.training.config;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Angel Zlatenov
 */
@Configuration
public class CamelConfig {

    @Autowired
    public CamelConfig(CamelContext camelContext) {
        camelContext.setStreamCaching(true);
        camelContext.setMessageHistory(false);
    }
}
