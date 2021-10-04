package com.epamjwd.task1.factory;

import com.epamjwd.task1.entity.DoubleArray;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomFactoryTest extends TestCase {
    CustomFactory customFactory;

    @BeforeClass
    public void setUp() {
        customFactory = new CustomFactory();
    }

    @Test
    public void testCreateArray() {
        Double[] nums = {1.1, 23.0, 657.1, 34.2};
        DoubleArray expected =new DoubleArray(nums);
        DoubleArray actual = customFactory.createArray(nums);
        Assert.assertEquals(expected,actual);
    }
}