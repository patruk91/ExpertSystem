package com.codecool;

import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;
import com.codecool.provider.ESProvider;
import com.codecool.repository.FactRepository;

public class Main {
    public static void main(String[] args) {
        RuleParser ruleParser = new FactParser();
        FactRepository factRepository = new FactRepository();
        ESProvider esProvider = new ESProvider(ruleParser, factRepository);

        esProvider.collectAnswers();

    }
}
