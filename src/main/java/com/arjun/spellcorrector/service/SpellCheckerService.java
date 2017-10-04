package com.arjun.spellcorrector.service;


import com.arjun.spellcorrector.ElasticsearchConfig;
import com.arjun.spellcorrector.models.Word;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.term.TermSuggestion;
import org.elasticsearch.search.suggest.term.TermSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpellCheckerService {

    public static final String TEST_SUGGESTER = "test_suggester";

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private ElasticsearchConfig ec;


    @Value("${indexName}")
    private String indexName;

    /**
     * this method queries the index for the termsuggestion
     *  and gets any suggestion and returns the entity which has all the suggested words.
     *
     * @param word
     * @return
     * @throws Exception
     */
    public Word checkSpellErrors(String word) throws Exception {
        Word spellCheckWord = new Word(word);
        List<String> suggestedWords = new ArrayList<>();


        //Build a suggestion query.
        SuggestBuilder.SuggestionBuilder suggestionBuilder =
                new TermSuggestionBuilder(TEST_SUGGESTER).text(word).field("word");

        SearchResponse searchResponse = ec.client().prepareSearch(indexName)
                .addSuggestion(suggestionBuilder)
                .execute().actionGet();


        //Get all suggestions
        TermSuggestion suggestion= searchResponse.getSuggest().getSuggestion(TEST_SUGGESTER);
        List<TermSuggestion.Entry> entryList = suggestion.getEntries();
        if(entryList != null) {
            TermSuggestion.Entry entry = entryList.get(0);
            List<TermSuggestion.Entry.Option> options =entry.getOptions();

            //Loop through all the suggestions and put it into the list
            if(options != null && options.size()!=0)  {
                options.forEach(option -> {
                    suggestedWords.add(option.getText().toString());
                });
            }
        }
        spellCheckWord.setSpellCheckWords(suggestedWords);
        return spellCheckWord;
    }

}
