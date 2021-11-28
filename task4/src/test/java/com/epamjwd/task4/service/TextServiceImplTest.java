package com.epamjwd.task4.service;

import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.exception.CompositeException;
import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.parser.TextParser;
import com.epamjwd.task4.parser.impl.ParagraphParser;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import com.epamjwd.task4.service.impl.TextServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextServiceImplTest {
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
    public void testSortParagraphBySentenceAmount() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        int actual = textService.sortParagraphBySentenceAmount(textComposite).get(0).getChild().get(0).getChild().size();
        int expected = 18;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindSentencesWithTheLongestWord() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        int actual = textService.findSentencesWithTheLongestWord(textComposite).size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDeleteSentences() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        int actual = textService.deleteSentences(textComposite, 6).getChild().size();
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAllSimilarWords() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        int actual = textService.findAllSimilarWords(textComposite).get("it");
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountVowels() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        Long actual = textService.countVowels((TextComposite) textComposite.getChild().get(3));
        Long expected = 6L;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountConsonants() throws CompositeException {
        TextServiceImpl textService = new TextServiceImpl();
        Long actual = textService.countConsonants((TextComposite) textComposite.getChild().get(3));
        Long expected = 7L;
        Assert.assertEquals(actual, expected);
    }
}