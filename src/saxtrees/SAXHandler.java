
package saxtrees;

import java.util.ArrayList;
import model.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private ArrayList<Tree> trees;
    private Tree currTree;

    private ArrayList<String> tags;
    private String currTag;
    private int currIndent;

    public SAXHandler() {
        trees = new ArrayList<>();
        tags = new ArrayList<>();
        currTag = "";
        currIndent = 0;
    }

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("start doc");
        currTag = "start";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String chars = new String(ch);
        String content = chars.substring(start, start + length);

//        System.out.println("chars: " + start +  " " + length);
//        System.out.println(content);

        switch (currTag) {
            case "start":
                break;
        }
        currTag = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("start");
        switch (currTag) {
            case "start":
                break;
        }

        // Store DOM structure
        if (!findAttribute(qName))
            tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("end");
    }

    boolean findAttribute(String attribute) {
        for (String attr : tags) {
            if (attr.equals(attribute))
                return true;
        }

        return false;
    }

    public ArrayList<String> getStructure() { return this.tags; }
}