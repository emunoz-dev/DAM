import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class ReadXML {
  private final String PATH_EXEC = System.getProperty("user.dir");
  private final String PATH_SPLIT = System.getProperty("file.separator");
  private final String PATH_SUBDIR = PATH_EXEC + PATH_SPLIT + "UF5" + PATH_SPLIT;
  private final String PATH_ABSOLUTE_XML = PATH_SUBDIR + "xml" + PATH_SPLIT + "files" + PATH_SPLIT + "carsfff.xml";

  public void readFile() throws MyException {
    try {
      File fileXml = new File(PATH_ABSOLUTE_XML);

      DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();

      Document xmlDoc = xmlBuilder.parse(fileXml);

    } catch (Exception e) {
      throw new MyException(100, e);
    }
  }

}
