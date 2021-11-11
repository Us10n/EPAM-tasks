package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class ParagraphParser implements TextParser {
    private static final String PARAGRAPH_DELIMITER = "\\r\\n";
    private final TextParser sentenceParer = new SentenceParser();

    @Override
    public CompositeComponent parse(String text) {
        CompositeComponent paragraphComposite = new CompositeComponent(ComponentType.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);

        for (String paragraph : paragraphs) {
            TextComponent sentenceComponent= sentenceParer.parse(paragraph);
            paragraphComposite.add(sentenceComponent);
        }
        return paragraphComposite;
    }
}
