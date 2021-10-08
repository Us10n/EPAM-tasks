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
    public void testAverage() {
        Double expected = 12.25d;
        Double actual = findService.average(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAverageUsingStream() {
        Double expected = 12.25d;
        Double actual = findService.averageUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMin() {
        Double expected = -7.1d;
        Double actual = findService.min(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMinUsingStream() {
        Double expected = -7.1d;
        Double actual = findService.minUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMax() {
        Double expected = 34.2d;
        Double actual = findService.max(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaxUsingStream() {
        Double expected = 34.2d;
        Double actual = findService.maxUsingStream(doubleArray);
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
    public void testPositiveNumberAmount() {
        Long expected = 2L;
        Long actual = findService.positiveNumberAmount(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPositiveNumberAmountUsingStream() {
        Long expected = 2L;
        Long actual = findService.positiveNumberAmountUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeNumberAmount() {
        Long expected = 2L;
        Long actual = findService.negativeNumberAmount(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeNumberAmountUsingStream() {
        Long expected = 2L;
        Long actual = findService.negativeNumberAmountUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSum() {
        Double expected= 49.;
        Double actual = findService.sum(doubleArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumUsingStream() {
        Double expected= 49.;
        Double actual = findService.sumUsingStream(doubleArray);
        Assert.assertEquals(expected, actual);
    }
}