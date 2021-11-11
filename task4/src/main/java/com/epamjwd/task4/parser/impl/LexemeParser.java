package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class LexemeParser implements TextParser {
    private static final String LEXEME_DELIMITER = "\\s";
    private static final String WORD_WITH_MARK_REGEX = "[А-Яа-я\\w]+";
    private final TextParser wordParser = new WordParser();
    private final TextParser expressionParser = new ExpressionParser();

    @Override
    public CompositeComponent parse(String sentence) {
        CompositeComponent lexemeComposite = new CompositeComponent(ComponentType.LEXEME);
        String[] lexemes = sentence.split(LEXEME_DELIMITER);

        for (String lexeme : lexemes) {
            if (lexeme.matches(WORD_WITH_MARK_REGEX)) {
                TextComponent wordComponent = wordParser.parse(lexeme);
                lexemeComposite.add(wordComponent);
            }else{
                TextComponent expressionComponent=expressionParser.parse(lexeme);
                lexemeComposite.add(expressionComponent);
            }
        }
        return lexemeComposite;
    }
}
