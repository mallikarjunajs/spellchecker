package com.arjun.spellcorrector.service;

import com.arjun.spellcorrector.models.Dictionary;

import java.util.List;

public interface DictionaryService {

    Dictionary save(Dictionary dictionaryWord);

    List<Dictionary> findByWord(String word);
}
