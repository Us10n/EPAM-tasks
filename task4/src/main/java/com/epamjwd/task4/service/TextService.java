package com.epamjwd.task4.service;

import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.exception.CompositeException;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<TextComponent> sortParagraphBySentenceAmount(TextComposite textComposite) throws CompositeException;
    List<TextComponent> findSentencesWithTheLongestWord(TextComposite textComposite) throws CompositeException;
    TextComponent deleteSentences(TextComposite textComposite, int minWordAmount) throws CompositeException;
    Map<String,Integer> findAllSimilarWords(TextComposite textComposite) throws CompositeException;
    Long countVowels(TextComposite sentenceComposite) throws CompositeException;
    Long countConsonants(TextComposite sentenceComposite) throws CompositeException;
}
