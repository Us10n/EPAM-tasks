package com.emapjwd.task3.builder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StaxDeviceBuilderTest {

    @Test
    public void testBuildDeviceSet() {
        StaxDeviceBuilder staxDeviceBuilder=new StaxDeviceBuilder();
        String XMLResource = "data/valid_file.xml";

        staxDeviceBuilder.buildDeviceSet(XMLResource);
        int expected=16;
        int actual=staxDeviceBuilder.getDeviceSet().size();
        Assert.assertEquals(actual,expected);
    }
}