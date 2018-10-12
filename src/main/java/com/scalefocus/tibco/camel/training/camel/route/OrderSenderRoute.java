package com.scalefocus.tibco.camel.training.camel.route;

import com.scalefocus.tibco.camel.training.exception.JMSException;
import com.scalefocus.tibco.camel.training.properties.Properties;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */

@Component
public class OrderSenderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(JMSException.class)
                .logExhaustedMessageHistory(false)
                .logStackTrace(false)
                .maximumRedeliveries("{{jms.maximumRedeliveries}}")
                .redeliveryDelay("{{jms.redeliveriesDelay}}")
                .log(LoggingLevel.ERROR, String.format("${exchangeProperty.%s}", Properties.APP_FAILED_LOG));

        from("jms:queue:{{jms.inputQueue}}").routeId("OrderSenderRoute")
                .log(LoggingLevel.INFO, String.format("Input queue body: %s", bodyAs(String.class)))
                .to("direct:QueueReceiver");
    }
}
