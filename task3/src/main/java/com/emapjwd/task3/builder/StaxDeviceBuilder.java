package com.emapjwd.task3.builder;

import com.emapjwd.task3.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.emapjwd.task3.builder.ComputerXmlTagType.*;

public class StaxDeviceBuilder extends AbstractDeviceBuilder {
    private static final Logger logger = LogManager.getLogger();
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    private XMLInputFactory inputFactory;

    public StaxDeviceBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildDeviceSet(String xmlFileName) {
        URL xmlFileUrl = this.getClass().getClassLoader().getResource(xmlFileName);
        try (FileInputStream inputStream = new FileInputStream(new File(xmlFileUrl.toURI()))) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (name.equals(PROCESSOR.getTag()) || name.equals(MOUSE.getTag())) {
                        AbstractDevice device = buildDevice(reader);
                        deviceSet.add(device);
                    }
                }
            }
        } catch (URISyntaxException | XMLStreamException | IOException e) {
            logger.error("Stax build device set error");
            e.printStackTrace();
        }

    }

    private AbstractDevice buildDevice(XMLStreamReader reader) throws XMLStreamException {
        AbstractDevice device = reader.getLocalName().equals(PROCESSOR.getTag())
                ? new Processor() : new Mouse();
        String deviceId = reader.getAttributeValue(null, ID.getTag());
        String deviceBrand = reader.getAttributeValue(null, BRAND.getTag());
        device.setDeviceId(deviceId);
        if (deviceBrand != null) {
            device.setBrand(deviceBrand);
        }

        while (reader.hasNext()) {
            String name;
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    fillDevice(device, reader);
                    break;
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (name.equals(PROCESSOR.getTag()) || name.equals(MOUSE.getTag())) {
                        return device;
                    }
                }
                break;
            }
        }
        return device;
    }

    private void fillDevice(AbstractDevice device, XMLStreamReader reader) throws XMLStreamException {
        String nameTag = reader.getLocalName();
        String value = findValue(reader);

        ComputerXmlTagType currentTag = ComputerXmlTagType.valueOf(nameTag.toUpperCase().replace(HYPHEN, UNDERSCORE));
        switch (currentTag) {
            case RELEASE:
                device.setReleaseDate(value);
                break;
            case ORIGIN:
                device.setOrigin(Country.valueOf(value.toUpperCase()));
                break;
            case PRICE:
                device.setPrice(Integer.parseInt(value));
                break;
            case PERIPHERAL:
                device.getParameter().setPeripheral(Boolean.parseBoolean(value));
                break;
            case POWER_USAGE:
                device.getParameter().setPowerUsage(Double.parseDouble(value));
                break;
            case GROUP:
                device.getParameter().setGroup(Group.valueOf(value.toUpperCase()));
                break;
            case COOLER_BUNDLED:
                device.getParameter().setCoolerBundled(Boolean.parseBoolean(value));
                break;
            case PORT:
                device.getParameter().setPort(Port.valueOf(value.toUpperCase()));
                break;
            case CRITICAL:
                device.setCritical(Boolean.parseBoolean(value));
                break;
            case DPI:
                ((Mouse) device).setDpi(Integer.parseInt(value));
                break;
            case CLOCK_SPEED:
                ((Processor) device).setClockSpeed(Double.parseDouble(value));
                break;
            case PARAMETERS:
                break;
        }

    }

    private String findValue(XMLStreamReader reader) throws XMLStreamException {
        String value = null;
        if (reader.hasNext()) {
            reader.next();
            value = reader.getText();
        }
        return value;
    }
}
