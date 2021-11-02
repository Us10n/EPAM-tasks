package com.emapjwd.task3.builder;

import com.emapjwd.task3.exception.BuilderException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DomDeviceBuilderTest {

    @Test
    public void testBuildDeviceSet() throws BuilderException {
        DomDeviceBuilder domDeviceBuilder=new DomDeviceBuilder();
        String XMLResource = "data/valid_file.xml";

        domDeviceBuilder.buildDeviceSet(XMLResource);
        int expected=16;
        int actual=domDeviceBuilder.getDeviceSet().size();
        Assert.assertEquals(actual,expected);
    }
}