package com.epamjwd.task1.parser;

import com.epamjwd.task1.entity.DoubleArray;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CustomParserTest extends TestCase {

    @Test
    public void testConvertStringToDoubleArray() {
        CustomParser parser = new CustomParser();
        Double[] nums = {11.1, 23.3, 9.12};
        DoubleArray expected = new DoubleArray(nums);
        String string = "11.1 23.3 9.12";
        Optional<DoubleArray> arrayOptional = parser.convertStringToDoubleArray(string);
        DoubleArray actual = arrayOptional.orElse(new DoubleArray());
        Assert.assertEquals(expected, actual);
    }
}