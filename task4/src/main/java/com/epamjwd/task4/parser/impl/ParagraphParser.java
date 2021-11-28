package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class ParagraphParser implements TextParser {
    private static final String PARAGRAPH_DELIMITER = "\\r\\n";
    private final TextParser sentenceParer = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);

        for (String paragraph : paragraphs) {
            TextComponent sentenceComponent= sentenceParer.parse(paragraph);
            paragraphComposite.add(sentenceComponent);
        }
        return paragraphComposite;
    }
}
