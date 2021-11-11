package com.epamjwd.task4.comparator;

import com.epamjwd.task4.entity.TextComponent;

import java.util.Comparator;

public class SentenceAmountComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent component1, TextComponent component2) {
        return Integer.compare(component1.getChild().size(), component2.getChild().size());
    }
}
