package com.epamjwd.task4;

import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.exception.CompositeException;
import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.parser.TextParser;
import com.epamjwd.task4.parser.impl.ParagraphParser;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import com.epamjwd.task4.service.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String fileName = "/data/text.txt";

    public static void main(String[] args) throws FileException, CompositeException {
        CustomReaderImpl reader = new CustomReaderImpl();
        String text = reader.readAll(fileName);
        TextParser textParser = new ParagraphParser();
        TextComposite textComposite = textParser.parse(text);
        TextServiceImpl textService = new TextServiceImpl();

        var deleteSentences = textService.deleteSentences(textComposite, 6);
        var consonantsAmount = textService.countConsonants((TextComposite) textComposite.getChild().get(3));
        var vowelsAmount = textService.countVowels((TextComposite) textComposite.getChild().get(3));
        var wordDictionary = textService.findAllSimilarWords(textComposite);
        var sortedParagraph = textService.sortParagraphBySentenceAmount(textComposite);
        var sentencesWithTheLongestWord = textService.findSentencesWithTheLongestWord(textComposite);
        logger.info("Paragraphs with sentences that contain more than 6 words:\n" + deleteSentences);
        logger.info("Consonants amount in the last sentence: " + consonantsAmount);
        logger.info("Vowels amount in the last sentence: " + vowelsAmount);
        logger.info("Words dictionary:\n" + wordDictionary);
        logger.info("Sorted paragraphs by sentence amount:\n" + sortedParagraph);
        logger.info("Sentence with the longest word:\n" + sentencesWithTheLongestWord);
    }
}
