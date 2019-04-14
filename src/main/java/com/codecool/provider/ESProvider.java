package com.codecool.provider;

import com.codecool.data.Fact;
import com.codecool.data.Question;
import com.codecool.parser.FactParser;
import com.codecool.parser.RuleParser;
import com.codecool.repository.FactRepository;
import com.codecool.repository.RuleRepository;

import java.util.*;

public class ESProvider {
    private RuleParser ruleParser;
    private FactParser factParser;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    private Map<String, Boolean> userAnswers;

    public ESProvider(RuleParser ruleParser, FactParser factParser) {
        this.ruleParser = ruleParser;
        this.factParser = factParser;
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        this.userAnswers = new LinkedHashMap<>();
    }

    public void collectAnswers() {
        while (ruleRepository.getIterator().hasNext()) {
            Question question = ruleRepository.getIterator().next();
            userAnswers.put(question.getId(), getAnswerByQuestion(question));
        }
    }

    private boolean getAnswerByQuestion(Question question) {
        Scanner reader = new Scanner(System.in);
        boolean match = false;
        boolean correctAnswer = false;

        while (!match) {
            System.out.println(question.getQuestion());
            System.out.println("Possible answers: " + question.getAnswer().getValues());
            String userInput = reader.nextLine();
            try {
                correctAnswer = question.getEvaluatedAnswer(userInput);
                match = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return correctAnswer;
    }

    public String evaluate() {
        while (factRepository.getIterator().hasNext()) {
            Fact fact = factRepository.getIterator().next();
            if (fact.getFacts().equals(userAnswers)) {
                return fact.getDescription();
            }
        }
        return "No suggestions!";
    }
}
