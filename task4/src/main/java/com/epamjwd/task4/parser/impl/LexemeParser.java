package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.CharacterLeaf;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class LexemeParser implements TextParser {
    private static final String LEXEME_DELIMITER = "\\s";
    private static final String WORD_WITH_MARK_REGEX = "[А-Яа-я\\w]+[,.?!…]?";
    private final TextParser wordParser = new WordParser();
    private final TextParser expressionParser = new ExpressionParser();

    @Override
    public TextComposite parse(String sentence) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] lexemes = sentence.split(LEXEME_DELIMITER);

        for (String lexeme : lexemes) {
            if (lexeme.matches(WORD_WITH_MARK_REGEX)) {
                char lastChar=lexeme.charAt(lexeme.length()-1);
                if(Character.isLetter(lastChar)) {
                    TextComponent wordComponent = wordParser.parse(lexeme);
                    lexemeComposite.add(wordComponent);
                }else {
                    String word=lexeme.substring(0,lexeme.length()-1);
                    TextComponent wordComponent=wordParser.parse(word);
                    CharacterLeaf characterLeaf=new CharacterLeaf(ComponentType.SIGN,lastChar);
                    wordComponent.add(characterLeaf);
                    lexemeComposite.add(wordComponent);
                }
            }else{
                TextComponent expressionComponent=expressionParser.parse(lexeme);
                lexemeComposite.add(expressionComponent);
            }
           String test= lexemeComposite.toString();
        }
        return lexemeComposite;
    }
}
