package com.arjun.spellcorrector;

import com.arjun.spellcorrector.models.Dictionary;
import com.arjun.spellcorrector.service.DictionaryService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;

@SpringBootApplication
public class SpellCorrectorApplication implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private DictionaryService dictionaryService;

	public static void main(String[] args) {
		SpringApplication.run(SpellCorrectorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		printElasticSearchInfo();

		//insert all the data into the index
		dictionaryService.save(new Dictionary("1", "disappoint"));
		dictionaryService.save(new Dictionary("2", "ecstasy"));
		dictionaryService.save(new Dictionary("3", "experience"));
		dictionaryService.save(new Dictionary("4", "consensus"));


	}

	//useful for debug, print elastic search details
	private void printElasticSearchInfo() {

		System.out.println("--ElasticSearch--");
		Client client = es.getClient();
		Map<String, String> asMap = client.settings().getAsMap();

		asMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});
		System.out.println("--ElasticSearch--");
	}
}
