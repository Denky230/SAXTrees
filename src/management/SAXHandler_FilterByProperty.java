package management;

import java.util.ArrayList;
import model.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler_FilterByProperty extends DefaultHandler {

    private Tree currTree;
    private String currProperty;
    private String filterProperty;
    private String filterPropertyOption;
    private ArrayList<Tree> treesFilteredByProperty;

    private String lastEvent;
    private IndentLevels indentLevel;

    public SAXHandler_FilterByProperty(String filterProperty, String filterPropertyOption) {
        this.filterProperty = filterProperty;
        this.filterPropertyOption = filterPropertyOption;
        treesFilteredByProperty = new ArrayList<>();
        currProperty = "";

        lastEvent = "";
        indentLevel = IndentLevels.ROOT;
    }

    @Override
    public void startDocument() throws SAXException {
        indentLevel = IndentLevels.ELEMENT_GROUP;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String chars = new String(ch);
        String content = chars.substring(start, start + length);
        content = content.trim();   // Get rid of blank spaces, tabs, etc.
        
        if (currProperty.equals(filterProperty) && content.equals(filterPropertyOption)) {
//            System.out.println("hi");
            treesFilteredByProperty.add(currTree);
        }
            
        
        currProperty = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (lastEvent.equals("start")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() + 1];
        }
        
        switch (indentLevel) {
            
            case ELEMENT:
                // Initialize element
                switch (qName) {
                    case "arbre":
                        currTree = new Tree();
                        break;
                }
                break;
            
            case PROPERTY:
                // Save current property name
                currProperty = qName;
                break;
        }

        lastEvent = "start";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastEvent.equals("end")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() - 1];
        }
        
        lastEvent = "end";
    }
    
    public ArrayList<Tree> getTreesFilteredByProperty() { return treesFilteredByProperty; }
}