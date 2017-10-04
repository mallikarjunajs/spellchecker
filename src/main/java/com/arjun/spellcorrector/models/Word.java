package com.arjun.spellcorrector.models;

import java.util.List;

public class Word {

    private String word;
    private List<String> spellCheckWords;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getSpellCheckWords() {
        return spellCheckWords;
    }

    public void setSpellCheckWords(List<String> spellCheckWords) {
        this.spellCheckWords = spellCheckWords;
    }
}
