package com.scalefocus.tibco.camel.training.camel.processor;

import com.scalefocus.tibco.camel.training.pojo.output.Message;
import com.scalefocus.tibco.camel.training.properties.Properties;
import com.scalefocus.tibco.camel.training.util.JaxbUtils;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


/**
 * @author Angel Zlatenov
 */
@Component
public class XmlProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getProperty(Properties.MESSAGE, Message.class);
        exchange.getIn().setBody(JaxbUtils.asString(message, Message.class));
    }
}
