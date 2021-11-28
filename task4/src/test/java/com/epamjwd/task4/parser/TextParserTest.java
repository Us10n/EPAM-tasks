package com.epamjwd.task4.parser;

import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.parser.impl.ParagraphParser;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextParserTest {
    private String text;
    private TextComposite textComposite;
    String fileName = "/data/test.txt";

    @BeforeTest
    public void init() throws FileException {
        CustomReaderImpl textReader = new CustomReaderImpl();
        text = textReader.readAll(fileName);

        TextParser paragraphParser = new ParagraphParser();
        textComposite = paragraphParser.parse(text);
    }

    @Test
    public void parseText() {
        TextParser paragraphParser = new ParagraphParser();
        TextComposite textComposite = paragraphParser.parse(text);
        int expected = 4;
        int actual = textComposite.getChild().size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseParagraph() {
        TextParser paragraphParser = new ParagraphParser();
        TextComposite textComposite = paragraphParser.parse(text);
        TextComponent paragraphComposite = textComposite.getChild().get(0);
        int expected = 2;
        int actual = paragraphComposite.getChild().size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseSentence() {
        TextParser paragraphParser = new ParagraphParser();
        TextComposite textComposite = paragraphParser.parse(text);
        TextComponent paragraphComposite = textComposite.getChild().get(0);
        TextComponent sentenceComposite=paragraphComposite.getChild().get(0);
        int expected = 18;
        int actual = sentenceComposite.getChild().size();
        Assert.assertEquals(actual, expected);
    }

}