package com.emapjwd.task3.builder;

import com.emapjwd.task3.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static com.emapjwd.task3.builder.ComputerXmlTagType.*;


public class DeviceSaxHandler extends DefaultHandler {
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    private AbstractDevice currentDevice;
    private ComputerXmlTagType currentTag;
    private Set<AbstractDevice> deviceSet;
    private EnumSet<ComputerXmlTagType> withText;

    public DeviceSaxHandler() {
        this.deviceSet = new HashSet<>();
        withText = EnumSet.range(ComputerXmlTagType.RELEASE, ComputerXmlTagType.PORT);
    }


    public Set<AbstractDevice> getDeviceSet() {
        return new HashSet<>(deviceSet);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (!qName.equals(ComputerXmlTagType.COMPUTER.getTag())) {
            String processorTag = ComputerXmlTagType.PROCESSOR.getTag();
            String mouseTag = ComputerXmlTagType.MOUSE.getTag();
            if (qName.equals(processorTag)
                    || qName.equals(mouseTag)) {
                String deviceId = attributes.getValue(ID.getTag());
                String deviceBrand = attributes.getValue(BRAND.getTag());

                currentDevice = qName.equals(processorTag) ? new Processor() : new Mouse();
                if (deviceBrand != null) {
                    currentDevice.setBrand(deviceBrand);
                }
                currentDevice.setDeviceId(deviceId);
            } else {
                ComputerXmlTagType qNameTag = ComputerXmlTagType.valueOf(qName.toUpperCase().replace(HYPHEN, UNDERSCORE));
                if (withText.contains(qNameTag)) {
                    currentTag = qNameTag;
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String processorTag = ComputerXmlTagType.PROCESSOR.getTag();
        String mouseTag = ComputerXmlTagType.MOUSE.getTag();
        if (qName.equals(processorTag)
                || qName.equals(mouseTag)) {
            deviceSet.add(currentDevice);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();
        if (currentTag == null) {
            return;
        }
        switch (currentTag) {
            case RELEASE:
                currentDevice.setReleaseDate(value);
                break;
            case ORIGIN:
                currentDevice.setOrigin(Country.valueOf(value.toUpperCase()));
                break;
            case PRICE:
                currentDevice.setPrice(Integer.parseInt(value));
                break;
            case CRITICAL:
                currentDevice.setCritical(Boolean.parseBoolean(value));
                break;
            case CLOCK_SPEED: {
                Processor processor = (Processor) currentDevice;
                processor.setClockSpeed(Double.parseDouble(value));
            }
            break;
            case DPI: {
                Mouse mouse = (Mouse) currentDevice;
                mouse.setDpi(Integer.parseInt(value));
            }
            break;
            case PERIPHERAL:
                currentDevice.getParameter().setPeripheral(Boolean.parseBoolean(value));
                break;
            case POWER_USAGE:
                currentDevice.getParameter().setPowerUsage(Double.parseDouble(value));
                break;
            case COOLER_BUNDLED:
                currentDevice.getParameter().setCoolerBundled(Boolean.parseBoolean(value));
                break;
            case GROUP:
                currentDevice.getParameter().setGroup(Group.valueOf(value.toUpperCase()));
                break;
            case PORT:
                currentDevice.getParameter().setPort(Port.valueOf(value.toUpperCase()));
                break;
            default:
                throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());

        }
        currentTag = null;
    }
}
