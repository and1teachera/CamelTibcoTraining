package com.scalefocus.tibco.camel.training.camel.route;

import com.scalefocus.tibco.camel.training.pojo.output.Message;
import com.scalefocus.tibco.camel.training.properties.Properties;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Angel Zlatenov
 */
@Component
public class ContentBasedConditionalRoute extends RouteBuilder {

    private final Predicate versionPredicate = ContentBasedConditionalRoute::matches;

    private static boolean matches(Exchange exchange) {
        Message message = exchange.getProperty(Properties.MESSAGE, Message.class);
        String newVersion = message.getNewVersion();
        return Objects.equals(newVersion, "false") || Objects.equals(newVersion, "0");
    }

    @Override
    public void configure() throws Exception {
        from("direct:ContentBasedConditionalRoute").routeId("ContentBasedConditionalRoute")
                .choice()
                    .when(versionPredicate)
                        .to("jms:queue:{{jms.oldVersionQueue}}")
                        .log(LoggingLevel.INFO, String.format("Transformed body: %s", "${body}"))
                    .endChoice()
                    .otherwise()
                        .to("jms:queue:{{jms.newVersionQueue}}")
                        .log(LoggingLevel.INFO, String.format("Transformed body: %s", "${body}"))
                    .endChoice()
                .end();
    }
}
