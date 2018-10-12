package com.scalefocus.tibco.camel.training.camel.processor;

import com.scalefocus.tibco.camel.training.pojo.input.Order;
import com.scalefocus.tibco.camel.training.properties.Properties;
import com.scalefocus.tibco.camel.training.util.JaxbUtils;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */

@Component
public class OrderProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        Order order = JaxbUtils.asObject(body, Order.class);
        exchange.setProperty(Properties.ORDER,JaxbUtils.asString(order, Order.class));
    }
}
