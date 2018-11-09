
package saxtrees;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import utils.Reader;

public class SAXTrees {

    static SAXHandler sh;
    static String PERSISTENCE = "datos.xml";

    public static void main(String[] args) {
        // Menu variables
        boolean exit = false;
        int menuOption;

        // Read XML file
        SAXFile();

        while (!exit) {
            System.out.println(
                    "\n*** Treeses ***\n"
                    + "1 - Show XML structure\n"
                    + "2 - Count trees\n"
                    + "3 - Check fully registered trees\n"
                    + "4 - Check trees by attribute\n"
                    + "0 - Exit"
            );

            try {
                menuOption = Reader.nextInt(4);
                switch (menuOption) {
                    case 1: // SHOW STRUCTURE
                        showStructure();
                        break;
                    case 2: // COUNT TREES
                        break;
                    case 3: // CHECK FULLY REGISTERED TREES
                        break;
                    case 4: // CHECK TREES BY ATTR
                        break;
                    case 0: // EXIT
                        exit = true;
                        break;
                    default:
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void SAXFile() {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            sh = new SAXHandler();

            parser.parse(new File(PERSISTENCE), sh);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(SAXTrees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void showStructure() {
        for (String tag : sh.getStructure()) {
            System.out.println("<" + tag + ">");
        }
    }
}
