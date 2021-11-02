package com.epamjwd.task2.parser.impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomParserImplTest {

    @Test
    public void testStringToCubeSpecification() {
        String cubeSpecification = "[1. 42.0 -1.] 2.2";
        CustomParserImpl parser = CustomParserImpl.getInstance();
        List<Double> expected = new ArrayList<Double>();
        expected.add(1.);
        expected.add(42.);
        expected.add(-1.);
        expected.add(2.2);
        List<Double> actual = parser.stringToCubeSpecification(cubeSpecification).get();
        Assert.assertEquals(actual, expected);
    }
}