package com.epamjwd.task4.service.impl;

import com.epamjwd.task4.comparator.SentenceAmountComparator;
import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.service.TextService;

import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    @Override
    public List<TextComponent> sortParagraphBySentenceAmount(CompositeComponent textComposite) {
        return textComposite.getChild().stream().sorted(new SentenceAmountComparator()).toList();
    }

    @Override
    public List<TextComponent> findSentencesWithTheLongestWord(CompositeComponent textComposite) {//todo
        return null;
    }

    @Override
    public CompositeComponent deleteSentences(CompositeComponent textComposite, int minWordAmount) {//todo
        return null;
    }

    @Override
    public Map<TextComponent, Integer> findAllSimilarWords(CompositeComponent textComposite) {//todo
        return null;
    }

    @Override
    public Integer countVowels(CompositeComponent sentenceComposite) {//todo
        return null;
    }

    @Override
    public Integer countConsonants(CompositeComponent sentenceComposite) {//todo
        return null;
    }
}
