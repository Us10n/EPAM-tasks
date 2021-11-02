package com.emapjwd.task3.builder.factory;

import com.emapjwd.task3.builder.AbstractDeviceBuilder;
import com.emapjwd.task3.builder.DomDeviceBuilder;
import com.emapjwd.task3.builder.SaxDeviceBuilder;
import com.emapjwd.task3.builder.StaxDeviceBuilder;
import com.emapjwd.task3.exception.BuilderException;

public class DeviceBuilderFactory {
    private static final DeviceBuilderFactory instance = new DeviceBuilderFactory();

    private enum BuilderType {
        SAX, STAX, DOM
    }

    private DeviceBuilderFactory() {
    }

    public static DeviceBuilderFactory getInstance() {
        return instance;
    }

    public AbstractDeviceBuilder createDeviceBuilder(String typeParser) throws BuilderException {
        BuilderType type = BuilderType.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DomDeviceBuilder();
            case STAX:
                return new StaxDeviceBuilder();
            case SAX:
                return new SaxDeviceBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
