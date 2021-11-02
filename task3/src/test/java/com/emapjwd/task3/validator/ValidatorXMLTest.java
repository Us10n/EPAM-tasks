package com.emapjwd.task3.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorXMLTest {

    String validXMLResource = "data/valid_file.xml";
    String invalidXMLResource = "data/invalid_file.xml";
    String xsdSchema = "data/test.xsd";
    String invalidXMLPath = "/data/invalid_file.xml";

    @Test
    public void testIsFileValid() {
        boolean actual = ValidatorXML.getInstance().isFileValid(validXMLResource, xsdSchema);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsFileInValid() {
        boolean actual = ValidatorXML.getInstance().isFileValid(invalidXMLResource, xsdSchema);
        Assert.assertFalse(actual);
    }

    @Test
    public void testFileNotFounded() {
        boolean actual = ValidatorXML.getInstance().isFileValid(invalidXMLPath, xsdSchema);
        Assert.assertFalse(actual);
    }
}