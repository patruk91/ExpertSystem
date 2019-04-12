package com.codecool.provider;

import com.codecool.parser.FactParser;
import com.codecool.repository.FactRepository;

public class ESProvider {
    private FactParser factParser;
    private FactRepository factRepository;

    public ESProvider(FactParser factParser, FactRepository factRepository) {
        this.factParser = factParser;
        this.factRepository = factRepository;
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {
        return false;
    }

    public String evaluate() {
        return "";
    }
}
