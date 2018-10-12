package com.scalefocus.tibco.camel.training.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Evgeni Stoykov
 */
public final class JaxbUtils {

    private JaxbUtils() {}

    public static String asString(Object object, Class<?> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        StringWriter writer = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    public static <T> T asObject(String content, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (StringReader reader = new StringReader(content)) {
            return (T) unmarshaller.unmarshal(reader);
        }
    }
}
