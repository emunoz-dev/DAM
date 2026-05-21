import java.io.File;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

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
  private final String PATH_ABSOLUTE_XML = PATH_SUBDIR + "xml" + PATH_SPLIT + "files" + PATH_SPLIT + "cars.xml";
  

  public List<Cars> listCars = new ArrayList<Cars>();
  public Map<Integer,Cars> mapCars = new HashMap<>();
  public Cars[] arrayCars;

  public ReadXML(String arg0) throws MyException {
    try {
      File fileXml = new File(PATH_ABSOLUTE_XML);

      DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();

      Document xmlDoc = xmlBuilder.parse(fileXml);
      xmlDoc.normalizeDocument();

      System.out.println("Root element: " + xmlDoc.getDocumentElement().getNodeName() );
      NodeList listChilds = xmlDoc.getDocumentElement().getChildNodes();
      for (int i = 0; i < listChilds.getLength(); i++) {
        Node auxNode = listChilds.item(i);
        if (auxNode.getNodeType() ==  xmlDoc.ELEMENT_NODE) {
          Element auxElement = (Element) auxNode;
          int idAux = Integer.parseInt( auxElement.getAttribute("id") ) ;
          
          String marcaAux = auxElement.getElementsByTagName("marca").item(0).getTextContent();
          String modelAux = auxElement.getElementsByTagName("modelo").item(0).getTextContent();
          int priceAux = Integer.parseInt( auxElement.getElementsByTagName("precio").item(0).getTextContent() );

          switch(arg0) {
            case "-M", "--map":
              Cars carAuxMap = new Cars(marcaAux, modelAux, priceAux);
              mapCars.put(idAux, carAuxMap);
              break;
            case "-L", "--list":
              Cars carAuxList = new Cars(marcaAux, modelAux, priceAux, idAux);
              this.listCars.add(carAuxList);
              break;
            case "-A", "--array":
              Cars carAuxArray = new Cars(marcaAux, modelAux, priceAux, idAux);
              // Can not used to because is necesary known the size before process logic.
              break;
          }
          
        }
      }



    } catch (Exception e) {
      throw new MyException(100, e);
    }
  }

  public List<Cars> getCarsList() {
    return this.listCars;
  }

  public Map<Integer, Cars> getCarsMap() {
    return this.mapCars;
  }

  public void printCars(String arg0) {
    switch(arg0) {
      case "-M", "--map":
        for (Map.Entry<Integer,Cars> entryItem : getCarsMap().entrySet()) {
          System.out.println(entryItem.getKey());
          System.out.println(entryItem.getValue().getMarca());
          System.out.println(entryItem.getValue().getModel());
          System.out.println(entryItem.getValue().getPrice());
        }
        break;
      case "-L", "--list":
        for (Cars itemList : getCarsList() ) {
          System.out.println(itemList.getId());
          System.out.println(itemList.getMarca());
          System.out.println(itemList.getModel());
          System.out.println(itemList.getPrice());
        }
        break;
      case "-A", "--array":
        break;
    }
    
  }

  

}
