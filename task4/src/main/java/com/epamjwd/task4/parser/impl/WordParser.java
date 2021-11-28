package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.CharacterLeaf;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class WordParser implements TextParser {
    @Override
    public TextComposite parse(String lexeme) {
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        for(char character: lexeme.toCharArray()){
            TextComponent characterComponent=new CharacterLeaf(ComponentType.CHARACTER, character);
            wordComposite.add(characterComponent);
        }
        return wordComposite;
    }
}
