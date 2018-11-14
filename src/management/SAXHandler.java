
package management;

import java.util.ArrayList;
import model.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private Tree currTree;
    private int numTotalTrees;
    private ArrayList<Tree> fullyRegisteredTrees;

    private String element;
    private String element_grp;
    private String currProperty;
    private String filterProperty;
    private ArrayList<String> properties;
    private ArrayList<String> filterPropertyOptions;

    private String lastEvent;
    private IndentLevels indentLevel;

    public SAXHandler(String filterProperty) {
        fullyRegisteredTrees = new ArrayList<>();
        numTotalTrees = 0;

//        element_grp = "";
//        element = "";
        properties = new ArrayList<>();
        filterPropertyOptions = new ArrayList<>();
        this.filterProperty = filterProperty;
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
        
        if (!content.equals("")) {
            setProperty(content);
            
            if (currProperty.equals(filterProperty) && !filterPropertyOptions.contains(content)) {
                filterPropertyOptions.add(content);
            }
        }
            

        currProperty = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (lastEvent.equals("start")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() + 1];
        }
        
        switch (indentLevel) {

            case ELEMENT_GROUP:
                break;

            case ELEMENT:
                // Initialize element
                switch (qName) {
                    case "arbre":
                        currTree = new Tree();
                        numTotalTrees++;
                        break;
                }
                break;

            case PROPERTY:
                // Save current property name
                currProperty = qName;

                // Store every non-stored property for later display
                if (!properties.contains(currProperty)) {
                    properties.add(currProperty);
                }
                break;
        }

        lastEvent = "start";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastEvent.equals("end")) {
            indentLevel = IndentLevels.values()[indentLevel.ordinal() - 1];
        }

        switch (indentLevel) {
            case ELEMENT:
                if (isTreeFullyRegistered(currTree))
                    fullyRegisteredTrees.add(currTree);
                break;
        }
        
        lastEvent = "end";
    }

    private boolean isPropertyStored(String attribute) {
        for (String attr : properties) {
            if (attr.equals(attribute))
                return true;
        }

        return false;
    }

    public ArrayList<String> getStructure() { return properties; }
    public ArrayList<String> getFilterPropertyOptions() { return filterPropertyOptions; }
    public int countTrees() { return numTotalTrees; }
    public ArrayList<Tree> getFullyRegisteredTrees() { return fullyRegisteredTrees; }
    
    void setProperty(String content) {
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
    }
    boolean isTreeFullyRegistered(Tree tree) {
        String treeString = tree.toString();
        return !treeString.contains("null");
    }
}