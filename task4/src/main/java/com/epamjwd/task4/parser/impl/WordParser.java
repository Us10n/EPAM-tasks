package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.CompositeLeaf;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class WordParser implements TextParser {
    @Override
    public CompositeComponent parse(String lexeme) {
        CompositeComponent wordComposite = new CompositeComponent(ComponentType.WORD);
        for(char character: lexeme.toCharArray()){
            TextComponent characterComponent=new CompositeLeaf(ComponentType.CHARACTER, character);
            wordComposite.add(characterComponent);
        }
        return wordComposite;
    }
}
