package com.codecool;

import com.codecool.parser.FactParser;
import com.codecool.provider.ESProvider;
import com.codecool.repository.FactRepository;

public class Main {
    public static void main(String[] args) {
        FactParser factParser = new FactParser();
        FactRepository factRepository = new FactRepository();
        ESProvider esProvider = new ESProvider(factParser, factRepository);

        esProvider.collectAnswers();

    }
}
