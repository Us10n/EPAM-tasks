package com.epamjwd.task1.service.impl;

import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exception.DoubleArrayException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindServiceImplTest {
    static FindServiceImpl findService;
    static DoubleArray doubleArray;

    @BeforeClass
    public static void setUp() {
        findService = new FindServiceImpl();
        Double[] nums = {-1.1, 23.0, -7.1, 34.2};
        doubleArray = new DoubleArray(nums);
    }

    @Test
    public void testGetAverage() {
        Double expected = 12.25d;
        Double actual = findService.getAverage(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageUsingStream() {
        Double expected = 12.25d;
        Double actual = findService.getAverageUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMin() {
        Double expected = -7.1d;
        Double actual = findService.getMin(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMinUsingStream() {
        Double expected = -7.1d;
        Double actual = findService.getMinUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMax() {
        Double expected = 34.2d;
        Double actual = findService.getMax(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMaxUsingStream() {
        Double expected = 34.2d;
        Double actual = findService.getMaxUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceByIndex() throws DoubleArrayException {
        Double[] nums = {0., -10.0, -7.1, 4.2};
        Double[] expectedNums={0., -10.0, -7.1, 1.};
        DoubleArray expected = new DoubleArray(expectedNums);
        DoubleArray actual = findService.replaceByIndex(new DoubleArray(nums),3,1.);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DoubleArrayException.class)
    public void testFindByIndexCustomException() throws DoubleArrayException {
        findService.replaceByIndex(doubleArray,-1,0.);
    }

    @Test
    public void testGetPositiveNumberAmount() {
        Long expected = 2L;
        Long actual = findService.getPositiveNumberAmount(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPositiveNumberAmountUsingStream() {
        Long expected = 2L;
        Long actual = findService.getPositiveNumberAmountUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNegativeNumberAmount() {
        Long expected = 2L;
        Long actual = findService.getNegativeNumberAmount(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNegativeNumberAmountUsingStream() {
        Long expected = 2L;
        Long actual = findService.getNegativeNumberAmountUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSum() {
        Double expected= 49.;
        Double actual = findService.getSum(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSumUsingStream() {
        Double expected= 49.;
        Double actual = findService.getSumUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }
}