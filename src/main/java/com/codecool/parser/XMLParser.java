package com.codecool.parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public abstract class XMLParser {
    private Document doc;

    void loadXmlDocument(String xmlPath) {
        try {
            File fileToRead = new File(xmlPath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(fileToRead);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace();
        }
    }

    protected Document getDoc() {
        return doc;
    }
}
