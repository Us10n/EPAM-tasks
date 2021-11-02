package com.epamjwd.task2.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextValidatorTest {

    @Test
    public void testIsLineContainSpecificationPositive() {
        String testString="[1. 23.1 -1.22] 9.1";
        TextValidator validator=TextValidator.getInstance();

        boolean actual =validator.isLineContainSpecification(testString);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsLineContainSpecificationNegative() {
        String testString="[1. 23.1 -adw 9.1";
        TextValidator validator=TextValidator.getInstance();

        boolean actual =validator.isLineContainSpecification(testString);
        Assert.assertFalse(actual);
    }
}