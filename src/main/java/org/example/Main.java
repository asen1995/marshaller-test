package org.example;

import org.example.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {

        // Create a new Person object
        Person person = new Person("John", "Doe", 30);

        // Create a JAXBContext
        JAXBContext context = JAXBContext.newInstance(Person.class);

        // Create a Marshaller from the context
        Marshaller marshaller = context.createMarshaller();

        // Set the Marshaller's properties
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the Person object to XML and assign it to a string
        StringWriter writer = new StringWriter();
        marshaller.marshal(person, writer);
        String xmlString = writer.toString();

        System.out.println("XML String: " + xmlString);
        // Unmarshal the XML string back to a Person object
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);
        Person person2 = (Person) unmarshaller.unmarshal(reader);

        // Print the original Person object and the unmarshalled Person object
        System.out.println("Original Person: " + person);
        System.out.println("Unmarshalled Person: " + person2);
    }
}
