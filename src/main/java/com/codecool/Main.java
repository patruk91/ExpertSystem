package com.codecool;

import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;
import com.codecool.provider.ESProvider;

public class Main {
    public static void main(String[] args) {
        RuleParser ruleParser = new RuleParser();
        FactParser factParser = new FactParser();
        ESProvider esProvider = new ESProvider(ruleParser, factParser);

        esProvider.collectAnswers();
        System.out.println("Suggested game: ");
        System.out.print(esProvider.evaluate());

    }
}
