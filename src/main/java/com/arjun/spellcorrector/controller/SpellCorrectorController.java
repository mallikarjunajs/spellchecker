package com.arjun.spellcorrector.controller;
import com.arjun.spellcorrector.models.Word;
import com.arjun.spellcorrector.service.SpellCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpellCorrectorController {

    @Autowired
    private SpellCheckerService service;

    @RequestMapping("/spellCheck")
    public Word getWords(@RequestParam("word") String word) throws Exception {
        return service.checkSpellErrors(word);
    }

}
