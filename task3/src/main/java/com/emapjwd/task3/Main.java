package com.emapjwd.task3;

import com.emapjwd.task3.builder.DomDeviceBuilder;
import com.emapjwd.task3.builder.SaxDeviceBuilder;
import com.emapjwd.task3.builder.StaxDeviceBuilder;
import com.emapjwd.task3.entity.AbstractDevice;
import com.emapjwd.task3.exception.BuilderException;
import com.emapjwd.task3.validator.ValidatorXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String xmlResource = "data/computer.xml";
    private static final String xsdSchema = "data/computer.xsd";

    public static void main(String[] args) throws BuilderException {
        if (!ValidatorXML.getInstance().isFileValid(xmlResource, xsdSchema)) {
            logger.info("File is not valid");
            return;
        }
        DomDeviceBuilder domDeviceBuilder = new DomDeviceBuilder();
        domDeviceBuilder.buildDeviceSet(xmlResource);
        logger.info("Dom parser:");
        for(AbstractDevice device: domDeviceBuilder.getDeviceSet()){
            logger.info(device);
        }

        SaxDeviceBuilder saxDeviceBuilder = new SaxDeviceBuilder();
        saxDeviceBuilder.buildDeviceSet(xmlResource);
        logger.info("Sam parser:");
        for(AbstractDevice device: saxDeviceBuilder.getDeviceSet()){
            logger.info(device);
        }

        StaxDeviceBuilder staxDeviceBuilder = new StaxDeviceBuilder();
        staxDeviceBuilder.buildDeviceSet(xmlResource);
        logger.info("Stax parser:");
        for(AbstractDevice device: staxDeviceBuilder.getDeviceSet()){
            logger.info(device);
        }


    }
}
