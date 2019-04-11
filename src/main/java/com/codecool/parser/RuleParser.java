package com.codecool.parser;

import com.codecool.data.Answer;
import com.codecool.data.Question;
import com.codecool.repository.RuleRepository;
import com.codecool.value.MultpileValue;
import com.codecool.value.SingleValue;
import com.codecool.value.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument("src/main/resources/rules.xml");
        parseRules(getDoc());
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

    private void parseRules(Document document) {
        NodeList nodeListRule = document.getElementsByTagName("Rule");
        for (int i = 0; i < nodeListRule.getLength(); i++) {
            Node nodeRule = nodeListRule.item(i);
            if (nodeRule.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeRule;
                addQuestion(element);
            }
        }
    }

    private void addQuestion(Element element) {
        int objectIndex = 0;
        String ruleId = element.getAttribute("id");
        String question = element.getElementsByTagName("Question").item(objectIndex).getTextContent();
        Answer answer = addAnswer(element);
        ruleRepository.addQuestion(new Question(ruleId, question, answer));
    }

    private Answer addAnswer(Element element) {
        int objectIndex = 0;
        Answer answer = new Answer();
        Element answerElement = (Element) element.getElementsByTagName("Question").item(objectIndex);
        NodeList selectionsList = answerElement.getElementsByTagName("Selection");

        for (int i = 0; i < selectionsList.getLength(); i++) {
            Element selectionValue = (Element) selectionsList.item(i);
            Value value = createValues(selectionValue);
            answer.addValue(value);
        }
        return answer;
    }

    private Value createValues(Element selectionValue) {
        Node nodeValue = selectionValue.getFirstChild().getNextSibling();
        String compareValue = nodeValue.getNodeName();
        String values = nodeValue.getAttributes().getNamedItem("value").getNodeValue();

        if (compareValue.equals("SingleValue")) {
            return createSingleValue(values, selectionValue);
        } else {
            return createMultipleValue(values, selectionValue);
        }
    }

    private Value createSingleValue(String values, Element selectionValue) {
        return new SingleValue(values, getTypeSelection(selectionValue));
    }

    private Value createMultipleValue(String values, Element selectionValue) {
        List<String> multipleValue = new ArrayList<>(Arrays.asList(values.split(",")));
        return new MultpileValue(multipleValue, getTypeSelection(selectionValue));
    }

    private boolean getTypeSelection(Element selectionValue) {
        return Boolean.valueOf(selectionValue.getAttributes().getNamedItem("value").getTextContent());
    }





}
