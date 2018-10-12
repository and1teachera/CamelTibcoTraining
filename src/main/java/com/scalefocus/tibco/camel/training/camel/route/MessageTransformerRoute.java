package com.scalefocus.tibco.camel.training.camel.route;

import com.scalefocus.tibco.camel.training.camel.transformer.MessageTransformer;
import com.scalefocus.tibco.camel.training.exception.MappingException;
import com.scalefocus.tibco.camel.training.properties.Properties;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */
@Component
public class MessageTransformerRoute extends RouteBuilder {

    private final MessageTransformer messageTransformer;

    @Autowired
    public MessageTransformerRoute(MessageTransformer messageTransformer) {
        this.messageTransformer = messageTransformer;
    }

    @Override
    public void configure() throws Exception {
        onException(MappingException.class)
                .handled(true)
                .logExhaustedMessageHistory(false)
                .logStackTrace(false)
                .log(LoggingLevel.ERROR, String.format("${exchangeProperty.%s}", Properties.APP_FAILED_LOG));

        from("direct:MessageTransformerRoute").routeId("MessageTransformerRoute")
                .transform().method(messageTransformer)
                .log(LoggingLevel.INFO, String.format("The transformed message is:  ${exchangeProperty.%s}", Properties.MESSAGE))
                .to("direct:XmlMarshaling");
    }
}
