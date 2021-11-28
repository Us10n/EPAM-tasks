package com.epamjwd.task4.service.impl;

import com.epamjwd.task4.comparator.SentenceAmountComparator;
import com.epamjwd.task4.entity.ComponentType;
import com.epamjwd.task4.entity.TextComponent;
import com.epamjwd.task4.entity.TextComposite;
import com.epamjwd.task4.exception.CompositeException;
import com.epamjwd.task4.service.TextService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    private static final String REGEX_VOWEL = "(?i:[aeiouyауоыиэяюёе])";
    private static final String REGEX_CONSONANT = "(?i:[a-zа-я&&[^aeiouyауоыиэяюёе]])";

    @Override
    public List<TextComponent> sortParagraphBySentenceAmount(TextComposite textComposite) throws CompositeException {
        if (textComposite == null) {
            throw new CompositeException("Passed parameters mustn't be null");
        }
        return textComposite.getChild().stream().sorted(new SentenceAmountComparator()).toList();
    }

    @Override
    public List<TextComponent> findSentencesWithTheLongestWord(TextComposite textComposite) throws CompositeException {
        if (textComposite == null) {
            throw new CompositeException("Passed parameters mustn't be null");
        }
        List<TextComponent> sentences = textComposite.getChild().stream()
                .flatMap(paragraph -> paragraph.getChild()
                        .stream()).toList();

        Integer maxWordLength = sentences.stream()
                .map(this::countMaxWordLength)
                .max(Integer::compareTo).orElseThrow(() -> new CompositeException("No words in sentence"));

        return sentences.stream()
                .filter(sentence -> countMaxWordLength(sentence) == maxWordLength)
                .collect(Collectors.toList());
    }

    @Override
    public TextComposite deleteSentences(TextComposite textComposite, int minWordAmount) throws CompositeException {
        if (textComposite == null || minWordAmount <= 0) {
            throw new CompositeException("Passed parameters wrong value");
        }
        TextComposite textClone = (TextComposite) textComposite.clone();
        List<TextComponent> paragraphs = textClone.getChild();

        paragraphs.forEach(paragraph -> {
            List<TextComponent> paragraphSentences = paragraph.getChild();
            paragraphSentences.forEach(
                    sentence -> {
                        if (sentence.getChild().stream().filter(lexeme -> lexeme.getType().equals(ComponentType.WORD)).count() < minWordAmount) {
                            paragraph.remove(sentence);
                        }
                    });
            if (paragraph.getChild().isEmpty()) {
                textClone.remove(paragraph);
            }
        });

        return textClone;
    }

    @Override
    public Map<String, Integer> findAllSimilarWords(TextComposite textComposite) throws CompositeException {
        if (textComposite == null) {
            throw new CompositeException("Passed parameters mustn't be null");
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        textComposite.getChild().stream()
                .flatMap(paragraph -> paragraph.getChild().stream())
                .flatMap(sentence -> sentence.getChild().stream())
                .filter(lexeme -> lexeme.getType().equals(ComponentType.WORD))
                .forEach(word -> {
                    int wordLength = word.toString().length();
                    char lastChar = word.toString().charAt(wordLength - 1);
                    String key = Character.isLetter(lastChar) ? word.toString() : word.toString().substring(0, wordLength - 1);
                    int occurs = wordsMap.getOrDefault(key, 0);
                    wordsMap.put(key, ++occurs);
                });

        return wordsMap;
    }

    @Override
    public Long countVowels(TextComposite sentenceComposite) throws CompositeException {
        if (sentenceComposite == null) {
            throw new CompositeException("Passed parameters mustn't be null");
        }
        return sentenceComposite.getChild().stream()
                .flatMap(lexeme -> lexeme.getChild().stream())
                .toList().stream()
                .flatMap(word -> word.getChild().stream())
                .filter(character -> character.toString().matches(REGEX_VOWEL))
                .count();
    }

    @Override
    public Long countConsonants(TextComposite sentenceComposite) throws CompositeException {
        if (sentenceComposite == null) {
            throw new CompositeException("Passed parameters mustn't be null");
        }
        return sentenceComposite.getChild().stream()
                .flatMap(lexeme -> lexeme.getChild().stream())
                .toList().stream()
                .flatMap(word -> word.getChild().stream())
                .filter(character -> character.toString().matches(REGEX_CONSONANT))
                .count();
    }

    private int countMaxWordLength(TextComponent sentenceComposite) {
        return sentenceComposite.getChild().stream()
                .filter(lexeme -> lexeme.getType().equals(ComponentType.WORD))
                .map(word -> {
                    int wordLength = word.toString().length();
                    char lastChar = word.toString().charAt(wordLength - 1);
                    return Character.isLetter(lastChar) ? word.getChild().size() : word.getChild().size() - 1;
                })
                .max(Integer::compareTo)
                .orElse(0);
    }
}
