package com.epamjwd.task4.parcer.impl;

import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.CompositeLeaf;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.parcer.TextParser;

public class ExpressionParser implements TextParser {

    @Override
    public CompositeComponent parse(String lexeme) {
        CompositeComponent expressionComposite = new CompositeComponent(ComponentType.EXPRESSION);
        for (char symbol : lexeme.toCharArray()) {
            ComponentType symbolType=Character.isLetter(symbol)? ComponentType.CHARACTER: ComponentType.SIGN;
            TextComponent characterComponent = new CompositeLeaf(symbolType,symbol);
            expressionComposite.add(characterComponent);
        }
        return expressionComposite;
    }
}
