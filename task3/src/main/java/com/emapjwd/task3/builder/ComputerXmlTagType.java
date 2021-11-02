package com.emapjwd.task3.builder;

public enum ComputerXmlTagType {
    ID("id"),
    BRAND("brand"),
    COMPUTER("computer"),
    PROCESSOR("processor"),
    MOUSE("mouse"),
    PARAMETERS("parameters"),
    RELEASE("release"),
    ORIGIN("origin"),
    PRICE("price"),
    CRITICAL("critical"),
    CLOCK_SPEED("clock-speed"),
    DPI("dpi"),
    PERIPHERAL("peripheral"),
    POWER_USAGE("power-usage"),
    COOLER_BUNDLED("cooler-bundled"),
    GROUP("group"),
    PORT("port");
    private final String value;

    ComputerXmlTagType(String value) {
        this.value = value;
    }

    public String getTag(){
        return value;
    }
}
