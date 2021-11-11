package com.epamjwd.task4.service;

import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.parser.TextParser;
import com.epamjwd.task4.parser.impl.ParagraphParser;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import com.epamjwd.task4.service.impl.TextServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextServiceImplTest {
    private String text;
    private CompositeComponent textComposite;
    String fileName = "/data/test.txt";

    @BeforeTest
    public void init() throws FileException {
        CustomReaderImpl textReader = new CustomReaderImpl();
        text = textReader.readAll(fileName);

        TextParser paragraphParser = new ParagraphParser();
        textComposite = paragraphParser.parse(text);
    }


    @Test
    public void testSortParagraphBySentenceAmount() {
        TextServiceImpl textService=new TextServiceImpl();
        int actual=textService.sortParagraphBySentenceAmount(textComposite).get(0).getChild().get(0).getChild().size();
        int expected=18;
        Assert.assertEquals(actual,expected);
    }
}