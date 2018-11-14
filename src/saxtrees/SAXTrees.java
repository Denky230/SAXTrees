package saxtrees;

import management.SAXHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import management.SAXHandler_FilterByProperty;
import model.Tree;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import utils.Reader;

public class SAXTrees {

    static SAXHandler sh;
    static String PERSISTENCE = "datos.xml";
    static final String FILTER_PROPERTY = "alcada";

    public static void main(String[] args) {
        // Menu variables
        boolean exit = false;
        int menuOption;

        try {
            // Read XML file
            sh = new SAXHandler(FILTER_PROPERTY);
            SAXFile(sh);

            while (!exit) {
                System.out.println(
                        "\n*** Treeses ***\n"
                        + "1 - Show XML structure\n"
                        + "2 - Count trees\n"
                        + "3 - Check fully registered trees\n"
                        + "4 - Check trees by attribute\n"
                        + "0 - Exit"
                );

                menuOption = Reader.nextInt(4);
                switch (menuOption) {
                    case 1: // SHOW STRUCTURE
                        showStructure();
                        break;
                    case 2: // COUNT TREES
                        countTrees();
                        break;
                    case 3: // CHECK FULLY REGISTERED TREES
                        showFullyRegisteredTrees();
                        break;
                    case 4: // CHECK TREES BY PROPERTY
                        showFilterPropertyOptions();
                        break;
                    case 0: // EXIT
                        exit = true;
                        break;
                    default:
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void SAXFile(DefaultHandler dh) throws IOException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new File(PERSISTENCE), dh);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new IOException("There was an error when accessing the program data");
        }
    }

    static void showStructure() {
        for (String tag : sh.getStructure()) {
            System.out.println("<" + tag + ">");
        }
    }    
    static void countTrees() {
        int numberOfTrees = sh.countTrees();
        System.out.println("There are " + numberOfTrees + " trees!");
    }
    static void showFullyRegisteredTrees() {
        ArrayList<Tree> fullyRegisteredTrees = sh.getFullyRegisteredTrees();
        for (Tree fullyRegisteredTree : fullyRegisteredTrees) {
            System.out.println(fullyRegisteredTree.toString());
        }
        System.out.println(fullyRegisteredTrees.size() + " with all data.");
    }
    static void showFilterPropertyOptions() throws IOException {
        ArrayList<String> filterPropertyOptions = sh.getFilterPropertyOptions();
        
        // Ask for property to filter trees with
        System.out.println("Choose which size's trees you want to see or type 0 to leave:");
        for (int i = 0; i < filterPropertyOptions.size(); i++) {
            System.out.println(i+1 + " - " + filterPropertyOptions.get(i));
        }
        
        int index = Reader.nextInt(filterPropertyOptions.size());
        if (index != 0) {
            int listIndex = index - 1;
            String filterPropertyOption = filterPropertyOptions.get(listIndex);
            
            // Read XML again, this time filtering trees by chosen FILTER_PROPERTY option
            SAXHandler_FilterByProperty sh = new SAXHandler_FilterByProperty(FILTER_PROPERTY, filterPropertyOption);
            SAXFile(sh);
            
            // List trees filtered by filterPropertyOption
            ArrayList<Tree> treesFilteredByProperty = sh.getTreesFilteredByProperty();
            System.out.println("*** Trees by: " + FILTER_PROPERTY + " - " + filterPropertyOption + " ***");
            for (Tree tree : treesFilteredByProperty) {
                System.out.println(tree.toString());
            }
        } else {
            System.out.println("Cya next time! :D");
        }
    }
}