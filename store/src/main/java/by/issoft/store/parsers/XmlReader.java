package by.issoft.store.parsers;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;


import java.util.LinkedHashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Map;
import java.io.File;


public class XmlReader {
    private Map<String, String> parsedMap;

    public XmlReader() {
        parsedMap = new LinkedHashMap<>();
    }

    private void createParsMap() {
        Node firstChild = parsXml().getFirstChild();
        NodeList childNodes = firstChild.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            String key = childNodes.item(i).getNodeName();
            String value = childNodes.item(i).getTextContent();
            parsedMap.put(key, value);
        }
    }

    public Map<String, String> getParsedMap() {
        this.createParsMap();
        return parsedMap;
    }

    private Document parsXml() {
        File file = new File("store/src/main/java/by/issoft/store/config/configFile.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = documentBuilderFactory.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
