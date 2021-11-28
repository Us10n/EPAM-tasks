package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {
    private static final String SENTENCE_REGEX="([A-ZА-Я].*?[\\.!?…][ \\n])|([A-ZА-Я].*?[\\.!?…]$)";
    private final TextParser lexemeParser=new LexemeParser();

    @Override
    public TextComposite parse(String paragraph) {
        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
        Pattern sentencePattern=Pattern.compile(SENTENCE_REGEX);
        Matcher sentenceMatcher=sentencePattern.matcher(paragraph);
        while (sentenceMatcher.find()){
            String sentence= sentenceMatcher.group();
            TextComponent paragraphComponent= lexemeParser.parse(sentence);
            sentenceComposite.add(paragraphComponent);
        }
        return sentenceComposite;
    }
}
