package com.codecool.provider;

import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;

public class ESProvider {
    private RuleParser ruleParser;
    private FactParser factParser;

    public ESProvider(RuleParser ruleParser, FactParser factParser) {
        this.ruleParser = ruleParser;
        this.factParser = factParser;
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
