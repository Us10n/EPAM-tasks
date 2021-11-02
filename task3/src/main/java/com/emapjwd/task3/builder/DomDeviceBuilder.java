package com.emapjwd.task3.builder;

import com.emapjwd.task3.entity.*;
import com.emapjwd.task3.exception.BuilderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.emapjwd.task3.builder.ComputerXmlTagType.*;

public class DomDeviceBuilder extends AbstractDeviceBuilder {
    private static final Logger logger = LogManager.getLogger();
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    private DocumentBuilder documentBuilder;

    public DomDeviceBuilder() throws BuilderException {
        super();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException exception) {
            logger.error("Parser configuration failed. " + exception);
            throw new BuilderException(exception);
        }
    }

    @Override
    public void buildDeviceSet(String xmlFileName) {
        try {
            String xmlFilePath = this.getClass().getClassLoader().getResource(xmlFileName).getPath();
            Document document = documentBuilder.parse(xmlFilePath);
            Element root = document.getDocumentElement();

            NodeList deviceList = root.getElementsByTagName(PROCESSOR.getTag());
            for (int i = 0; i < deviceList.getLength(); i++) {
                Element deviceElement = (Element) deviceList.item(i);
                AbstractDevice device = buildDevice(deviceElement);
                deviceSet.add(device);
            }

            deviceList = root.getElementsByTagName(MOUSE.getTag());
            for (int i = 0; i < deviceList.getLength(); i++) {
                Element deviceElement = (Element) deviceList.item(i);
                AbstractDevice device = buildDevice(deviceElement);
                deviceSet.add(device);
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private AbstractDevice buildDevice(Element deviceElement) {
        AbstractDevice device = deviceElement.getTagName().equals(PROCESSOR.getTag())
                ? new Processor() : new Mouse();
        String value;

        value = deviceElement.getAttribute(ID.getTag());
        device.setDeviceId(value);
        if ((value = deviceElement.getAttribute(BRAND.getTag())) != null) {
            device.setBrand(value);
        }
        value = getElementValue(deviceElement, RELEASE.getTag());
        device.setReleaseDate(value);
        value = getElementValue(deviceElement, ORIGIN.getTag());
        device.setOrigin(Country.valueOf(value.toUpperCase()));
        value = getElementValue(deviceElement, PRICE.getTag());
        device.setPrice(Integer.parseInt(value));

        Parameter parameter = new Parameter();
        value = getElementValue(deviceElement, PERIPHERAL.getTag());
        parameter.setPeripheral(Boolean.parseBoolean(value));
        value = getElementValue(deviceElement, POWER_USAGE.getTag());
        parameter.setPowerUsage(Double.parseDouble(value));
        value = getElementValue(deviceElement, COOLER_BUNDLED.getTag());
        parameter.setCoolerBundled(Boolean.parseBoolean(value));
        value = getElementValue(deviceElement, GROUP.getTag());
        parameter.setGroup(Group.valueOf(value.toUpperCase()));
        value = getElementValue(deviceElement, PORT.getTag());
        parameter.setPort(Port.valueOf(value.toUpperCase()));
        device.setParameter(parameter);

        value = getElementValue(deviceElement, CRITICAL.getTag());
        device.setCritical(Boolean.parseBoolean(value));

        if (deviceElement.getTagName().equals(PROCESSOR.getTag())) {
            value = getElementValue(deviceElement, CLOCK_SPEED.getTag());
            ((Processor) device).setClockSpeed(Double.parseDouble(value));
        } else {
            value = getElementValue(deviceElement, DPI.getTag());
            ((Mouse) device).setDpi(Integer.parseInt(value));
        }

        return device;
    }

    private String getElementValue(Element element, String elementTag) {
        Node node = element.getElementsByTagName(elementTag).item(0);
        return node.getTextContent();
    }
}
