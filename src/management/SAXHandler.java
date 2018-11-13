
package management;

import java.util.ArrayList;
import model.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private ArrayList<Tree> trees;
    private int numTrees;
    private Tree currTree;

    private String element_grp;
    private String element;
    private ArrayList<String> properties;
    private String currProperty;

    private String lastEvent;
    private IndentLevels indentLevel;

    public SAXHandler() {
        trees = new ArrayList<>();
        numTrees = 0;

        element_grp = "";
        element = "";
        properties = new ArrayList<>();
        currProperty = "";

        lastEvent = "";
        indentLevel = IndentLevels.ROOT;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start doc");
        indentLevel = IndentLevels.ELEMENT_GROUP;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String chars = new String(ch);
        String content = chars.substring(start, start + length);

        switch (currProperty) {
            case "codi":
                currTree.setCode(content);
                break;
            case "posicioX_ETRS89":
                currTree.setPosX(Double.parseDouble(content));
                break;
            case "posicioY_ETRS89":
                currTree.setPosY(Double.parseDouble(content));
                break;
            case "latitud_WGS84":
                currTree.setLatitude(Double.parseDouble(content));
                break;
            case "longitud_WGS84":
                currTree.setLongitude(Double.parseDouble(content));
                break;
            case "tipusElement":
                currTree.setElementType(content);
                break;
            case "espaiVerd":
                currTree.setGreenSpace(content);
                break;
            case "adreca":
                currTree.setDirection(content);
                break;
            case "alcada":
                currTree.setHeight(content);
                break;
            case "catEspecieId":
                currTree.setSpecieCategoryID(Integer.parseInt(content));
                break;
            case "nomCientific":
                currTree.setCientificName(content);
                break;
            case "nomEsp":
                currTree.setNameES(content);
                break;
            case "nomCat":
                currTree.setNameCAT(content);
                break;
            case "categoriaArbrat":
                currTree.setTreeCategory(content);
                break;
            case "ampladaVorera":
                currTree.setVoreraWidth(content);
                break;
            case "plantacioDT":
                currTree.setPlantacioDT(content);
                break;
            case "tipAigua":
                currTree.setWaterType(content);
                break;
            case "tipReg":
                currTree.setTipReg(content);
                break;
            case "tipSuperf":
                currTree.setSurfaceType(content);
                break;
            case "tipSuport":
                currTree.setSupportType(content);
                break;
            case "cobertaEscocell":
                currTree.setTreeHoleCover(content);
                break;
            case "midaEscocell":
                currTree.setTreeHoleSize(content);
                break;
            case "voraEscocell":
                currTree.setTreeHoleVora(content);
                break;
        }

        currProperty = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("start - " + qName + " - ");

        if (lastEvent.equals("start")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() + 1];
        }

        switch (indentLevel) {

            case ELEMENT_GROUP:
                // Save current element group name
                element_grp = qName;
                break;

            case ELEMENT:
                // Initialize element
                switch (qName) {
                    case "arbre":
                        currTree = new Tree();
                        numTrees++;
                        break;
                }
                break;

            case PROPERTY:
                // Save current property name
                currProperty = qName;

                // Store every non-stored property for later display
                if (!isPropertyStored(qName)) {
                    properties.add(qName);
                }
                break;
        }

        lastEvent = "start";
        System.out.println(indentLevel.name());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("end - ");

        switch (indentLevel) {
            case ELEMENT:
                trees.add(currTree);
                break;
        }

        if (lastEvent.equals("end")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() - 1];
        }
        lastEvent = "end";
        System.out.println(indentLevel.name() + "\n");
    }

    private boolean isPropertyStored(String attribute) {
        for (String attr : properties) {
            if (attr.equals(attribute))
                return true;
        }

        return false;
    }

    public ArrayList<String> getStructure() { return this.properties; }
    public int countTrees() { return this.trees.size(); }
}