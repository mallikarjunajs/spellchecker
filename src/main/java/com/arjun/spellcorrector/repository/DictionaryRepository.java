package com.arjun.spellcorrector.repository;


import com.arjun.spellcorrector.models.Dictionary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface DictionaryRepository extends ElasticsearchRepository<Dictionary, String> {
    List<Dictionary> findByWord(String word);
}
