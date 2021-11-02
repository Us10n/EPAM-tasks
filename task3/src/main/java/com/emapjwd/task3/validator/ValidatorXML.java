package com.emapjwd.task3.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ValidatorXML {
    private static final Logger logger = LogManager.getLogger();
    private static final ValidatorXML instance = new ValidatorXML();

    public static ValidatorXML getInstance() {
        return instance;
    }

    public boolean isFileValid(String xmlResource, String xsdResource) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            URL schemaFileUrl = this.getClass().getClassLoader().getResource(xsdResource);
            URL xmlFileUrl = this.getClass().getClassLoader().getResource(xmlResource);
            if (xmlFileUrl == null || schemaFileUrl == null) {
                logger.error(xmlResource + " and/or " + xsdResource + " wasn't found");
                return false;
            }
            File schemaFile = new File(schemaFileUrl.toURI());
            File xmlFile = new File(xmlFileUrl.toURI());
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFile);
            validator.validate(source);
        } catch (SAXException | IOException | URISyntaxException e) {
            logger.error(xmlResource + " file validation error with " + xmlResource + " schema");
            return false;
        }
        return true;
    }
}

