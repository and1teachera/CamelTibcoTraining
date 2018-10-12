package com.scalefocus.tibco.camel.training.camel.transformer;


import com.scalefocus.tibco.camel.training.exception.MappingException;
import com.scalefocus.tibco.camel.training.pojo.input.Order;
import com.scalefocus.tibco.camel.training.pojo.output.Message;
import com.scalefocus.tibco.camel.training.properties.Properties;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Angel Zlatenov
 */

@Component
public class MessageTransformer  {

    public void transform(final Exchange exchange) throws Exception {
        Order order = exchange.getProperty(Properties.ORDER, Order.class);
        Message result = mapOrderToMessage(order);
        exchange.setProperty(Properties.MESSAGE, result);
    }

    private Message mapOrderToMessage(Order order) throws MappingException, DatatypeConfigurationException {
        Message message = new Message();
        message.setTransactionType(composeTransactionType(order.getOrderId()));
        message.setTransactionId(Optional.ofNullable(order.getOrderId()).orElseThrow(MappingException::new));
        message.setClientAddress(composeClientAddress(order.getCustomer().getAddress()));
        message.setClientData(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        message.setPriceSum(Optional.ofNullable(order.getItems()).orElse(Collections.emptyList()).stream().mapToDouble(Order.Items::getPrice).sum());
        message.setNewVersion(Optional.ofNullable(order.isVersion()).orElseThrow(MappingException::new).toString());
        message.setPromotionApplied(hasPromotion(order.getItems()));

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(Date.from(Instant.now()));
        message.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));

        List<Message.Products> products = message.getProducts();
        products.addAll(composeProducts(order.getItems()));

        List<Message.AdditionalData> additionalData = message.getAdditionalData();
        additionalData.addAll(composeAdditionalData(order.getInvoices()));

        return message;
    }

    private List<Message.Products> composeProducts(List<Order.Items> items) {
        return items.stream().map(item ->  {
            Message.Products products = new Message.Products();
            products.setName(item.getName());
            products.setPrice(String.valueOf(item.getPrice()));
            products.setType(item.getType());
            products.setPromotion(Optional.ofNullable(item.getPromotion()).map(Order.Items.Promotion::getPromotionId)
                    .map(Boolean::valueOf)
                    .orElse(false));
            return products;
        }).collect(Collectors.toList());
    }

    private List<Message.AdditionalData> composeAdditionalData(List<Order.Invoices> invoices) {
        List<Order.Invoices> invoicesList = Optional.ofNullable(invoices).orElse(Collections.emptyList());
        return IntStream.of(0, invoicesList.size() -1).boxed()
                .map(pos -> createAdditionalDataFromInvoice(pos, invoicesList.get(pos)))
                .collect(Collectors.toList());
    }

    private Message.AdditionalData createAdditionalDataFromInvoice(Integer pos, Order.Invoices invoice) {
            Message.AdditionalData additionalData = new Message.AdditionalData();
                additionalData.setIdentificator(invoice.getId());
                additionalData.setType("Invoice");
                additionalData.setPosition(pos);
                return additionalData;
    }

    private boolean hasPromotion(List<Order.Items> items) {
        return Optional.ofNullable(items).orElse(Collections.emptyList()).stream().anyMatch(item -> Objects.nonNull(item.getPromotion()));
    }

    private String composeClientAddress(Order.Customer.Address address) {
        return String.join(address.getAddressLine1()," ",address.getCity()," ",Optional.ofNullable(address.getZipCode()).orElse(StringUtils.EMPTY));
    }

    private String composeTransactionType(String orderId) {
        return String.join(" ",Optional.ofNullable(orderId).filter(StringUtils::isNoneEmpty).orElse("0000"),"@",Date.from(Instant.now()).toString());
    }
}
