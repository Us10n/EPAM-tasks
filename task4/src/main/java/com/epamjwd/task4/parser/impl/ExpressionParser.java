package com.epamjwd.task4.parser.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.CharacterLeaf;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parser.TextParser;

public class ExpressionParser implements TextParser {

    @Override
    public TextComposite parse(String lexeme) {
        TextComposite expressionComposite = new TextComposite(ComponentType.EXPRESSION);
        for (char symbol : lexeme.toCharArray()) {
            ComponentType symbolType=Character.isLetter(symbol)? ComponentType.CHARACTER: ComponentType.SIGN;
            TextComponent characterComponent = new CharacterLeaf(symbolType,symbol);
            expressionComposite.add(characterComponent);
        }
        return expressionComposite;
    }
}
