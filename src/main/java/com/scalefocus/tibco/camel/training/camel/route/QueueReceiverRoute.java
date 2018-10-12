package com.scalefocus.tibco.camel.training.camel.route;

import com.scalefocus.tibco.camel.training.camel.processor.OrderProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */
@Component
public class QueueReceiverRoute extends RouteBuilder {


    private final OrderProcessor orderProcessor;

    @Autowired
    public QueueReceiverRoute(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;

    }

    @Override
    public void configure() throws Exception {
        from("direct:QueueReceiver").routeId("QueueReceiverRoute")
                .process(orderProcessor)
                .log(LoggingLevel.INFO, "${exchangeProperty.Order}")
                .to("direct:MessageTransformerRoute");
    }
}
