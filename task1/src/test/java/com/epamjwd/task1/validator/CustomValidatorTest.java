package com.epamjwd.task1.validator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomValidatorTest extends TestCase {
    CustomValidator validator;

    @BeforeClass
    public void setUp() {
        validator=new CustomValidator();
    }

    @Test
    public void testIsTextLineValidFalse() {
        String str="1a0 1. 324.4";
        boolean expected=false;
        boolean actual= validator.isTextLineValid(str);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIsTextLineValidTrue() {
        String str="1.0 1. 324.4";
        boolean expected=true;
        boolean actual= validator.isTextLineValid(str);
        Assert.assertEquals(expected,actual);
    }

}