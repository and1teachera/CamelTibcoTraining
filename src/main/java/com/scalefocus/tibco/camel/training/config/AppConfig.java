package com.scalefocus.tibco.camel.training.config;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

/**
 * @author Angel Zlatenov
 */

@Configuration
public class AppConfig {

    //Active MQ
    @Autowired
    private Environment environment;

    @Bean
    public javax.jms.ConnectionFactory jmsConnectionFactory() {
        return new org.apache.activemq.ActiveMQConnectionFactory(
                environment.getProperty("jms.brokerUrl"));
    }

    @Primary
    @Bean(initMethod = "start", destroyMethod = "stop")
    public org.apache.activemq.pool.PooledConnectionFactory pooledConnectionFactory() {
        PooledConnectionFactory factory = new PooledConnectionFactory();
        factory.setConnectionFactory(jmsConnectionFactory());
        factory.setMaxConnections(Integer.parseInt(environment
                .getProperty("activemq.pooledConnectionFactory.maxConnections")));
        return factory;
    }

    @Bean
    public org.apache.camel.component.jms.JmsConfiguration jmsConfiguration() {
        JmsConfiguration jmsConfiguration = new JmsConfiguration();
        jmsConfiguration.setConnectionFactory(pooledConnectionFactory());
        return jmsConfiguration;
    }

    @Bean
    public org.apache.activemq.camel.component.ActiveMQComponent activeMq(@Autowired CamelContext camelContext) {
        final ActiveMQComponent activeMq = new ActiveMQComponent();
        activeMq.setConfiguration(jmsConfiguration());
        camelContext.addComponent("jms",activeMq);
        return activeMq;
    }
}
