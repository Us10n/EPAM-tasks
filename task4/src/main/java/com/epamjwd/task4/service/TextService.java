package com.epamjwd.task4.service;

import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.entity.TextComponent;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<TextComponent> sortParagraphBySentenceAmount(CompositeComponent textComposite);
    List<TextComponent> findSentencesWithTheLongestWord(CompositeComponent textComposite);
    TextComponent deleteSentences(CompositeComponent textComposite,int minWordAmount);
    Map<TextComponent,Integer> findAllSimilarWords(CompositeComponent textComposite);
    Integer countVowels(CompositeComponent sentenceComposite);
    Integer countConsonants(CompositeComponent sentenceComposite);
}
