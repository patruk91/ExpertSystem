package com.codecool.parser;

import com.codecool.data.Answer;
import com.codecool.data.Fact;
import com.codecool.data.Question;
import com.codecool.repository.FactRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends  XMLParser{
    private FactRepository factRepository;

    public FactParser() {
        this.factRepository = new FactRepository();
        loadXmlDocument("src/main/resources/facts.xml");
        parseFacts(getDoc());
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    private void parseFacts(Document document) {
        NodeList nodeListFact = document.getElementsByTagName("Fact");
        for (int i = 0; i < nodeListFact.getLength(); i++) {
            Node nodeFact = nodeListFact.item(i);
            if (nodeFact.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeFact;
                Fact fact = createFact(element);

                factRepository.addFact(fact);
            }
        }
    }

    private Fact createFact(Element element) {
        int objectIndex = 0;
        String factId = element.getAttribute("id");
        String description = element.getElementsByTagName("Description")
                .item(objectIndex).getAttributes().getNamedItem("value").getNodeValue();
        Fact fact = new Fact(factId, description);
        setFactsValues(element, fact);
        return fact;
    }
    private void setFactsValues(Element element, Fact fact) {
        Element evalsElement = (Element) element.getElementsByTagName("Evals").item(0);
        NodeList evalList = evalsElement.getElementsByTagName("Eval");

        for (int i = 0; i < evalList.getLength(); i++) {
            String evalId = evalList.item(i).getAttributes().getNamedItem("id").getNodeValue();
            String evalValue = evalList.item(i).getFirstChild().getTextContent();
            fact.setFactValueById(evalId, Boolean.valueOf(evalValue));
        }
    }
}
