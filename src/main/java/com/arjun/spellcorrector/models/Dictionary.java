package com.arjun.spellcorrector.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Document(indexName="dictionary", type="dictionary")
@Mapping(mappingPath = "/mappings/mappings.json")
public class Dictionary {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String word;

    public Dictionary(String id, String word) {
        this.id = id;
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
    @Override
    public String toString() {
        return "Dictionary {" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}