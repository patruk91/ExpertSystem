package com.codecool.parser;

import com.codecool.repository.FactRepository;
import org.w3c.dom.Document;

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
        
    }
}
