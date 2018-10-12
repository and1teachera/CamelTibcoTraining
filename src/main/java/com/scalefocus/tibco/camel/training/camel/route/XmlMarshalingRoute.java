package com.scalefocus.tibco.camel.training.camel.route;

import com.scalefocus.tibco.camel.training.camel.processor.XmlProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */
@Component
public class XmlMarshalingRoute extends RouteBuilder {

    private final XmlProcessor xmlProcessor;

    @Autowired
    public XmlMarshalingRoute(XmlProcessor xmlProcessor) {
        this.xmlProcessor = xmlProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("direct:XmlMarshaling").routeId("XmlMarshalingRoute")
                .process(xmlProcessor)
                .log(LoggingLevel.INFO, String.format("Transformed body: %s", "${body}"))
                .to("direct:ContentBasedConditionalRoute");
    }
}
