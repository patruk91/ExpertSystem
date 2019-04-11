package com.codecool.parser;

import com.codecool.repository.RuleRepository;

public class RuleParser extends XMLParser {
    RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument("src/main/resources/rules.xml");
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;

    }



}
