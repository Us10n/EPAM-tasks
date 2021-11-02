package com.emapjwd.task3.builder;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SaxDeviceBuilderTest {

    @Test
    public void testBuildDeviceSet() {
        SaxDeviceBuilder saxDeviceBuilder = new SaxDeviceBuilder();
        String XMLResource = "data/valid_file.xml";

        saxDeviceBuilder.buildDeviceSet(XMLResource);
        int expected=16;
        int actual=saxDeviceBuilder.getDeviceSet().size();
        Assert.assertEquals(actual,expected);
    }
}