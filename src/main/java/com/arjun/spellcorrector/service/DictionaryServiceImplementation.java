package com.arjun.spellcorrector.service;

import com.arjun.spellcorrector.models.Dictionary;
import com.arjun.spellcorrector.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImplementation implements DictionaryService {

    private DictionaryRepository dictionaryRepository;

    @Autowired
    public DictionaryServiceImplementation(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public Dictionary save(Dictionary productDetails) {
        return dictionaryRepository.save(productDetails);
    }

    @Override
    public List<Dictionary> findByWord(String name) {
        return dictionaryRepository.findByWord(name);
    }
}
