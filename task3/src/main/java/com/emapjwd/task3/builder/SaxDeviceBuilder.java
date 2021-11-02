package com.emapjwd.task3.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxDeviceBuilder extends AbstractDeviceBuilder {
    private static final Logger logger = LogManager.getLogger();
    private final SAXParserFactory factory;

    public SaxDeviceBuilder() {
        this.factory = SAXParserFactory.newInstance();
    }

    @Override
    public void buildDeviceSet(String xmlFileName) {
        DeviceSaxHandler saxHandler = new DeviceSaxHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxHandler);
            String xmlFilePath = this.getClass().getClassLoader().getResource(xmlFileName).getPath();
            reader.parse(xmlFilePath);
            deviceSet = saxHandler.getDeviceSet();
        } catch (SAXException | IOException e) {
            logger.error("Build device set error", e);
            e.printStackTrace();
        }
    }


}
