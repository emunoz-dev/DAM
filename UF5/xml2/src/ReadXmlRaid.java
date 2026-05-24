import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ReadXmlRaid {

  private String pathXml;

  public ReadXmlRaid() {
    // From git project
    this.pathXml = System.getProperty("user.dir");
    this.pathXml += System.getProperty("file.separator");
    this.pathXml += "UF5" + System.getProperty("file.separator") + "xml2" + System.getProperty("file.separator");
    this.pathXml += "files" + System.getProperty("file.separator") + "raid.xml";
  }

  public Document loadDocumentXml() throws MyException {
    boolean testRead;
    Document docXmlRaid;
    try {
      File fXml = new File(this.pathXml);
      testRead = fXml.canRead();
      if (!testRead) {
        throw new MyException(100, null);
      }
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      docXmlRaid = docBuilder.parse(fXml);
    } catch (Exception e) {
      throw new MyException(100, e);
    }
    return docXmlRaid;
  }

  public Player[] makePlayers(Document loadedXml) {
    NodeList listPlayers = loadedXml.getElementsByTagName("Player");
    int numPlayers = listPlayers.getLength();
    Player[] players = new Player[numPlayers];

    for (int i = 0; i < numPlayers; i++) {
      Element elementPlayer = (Element) listPlayers.item(i);

      // 1. Datos básicos
      String name = elementPlayer.getAttribute("name");
      String race = elementPlayer.getElementsByTagName("race").item(0).getTextContent();

      // 2. Stats de combate
      Element elementStats = (Element) elementPlayer.getElementsByTagName("stats").item(0);
      int health = Integer.parseInt(elementStats.getElementsByTagName("health").item(0).getTextContent());
      int armor = Integer.parseInt(elementStats.getElementsByTagName("armor").item(0).getTextContent());
      int baseAttack = Integer.parseInt(elementStats.getElementsByTagName("baseAttack").item(0).getTextContent());
      int baseAvoid = Integer.parseInt(elementStats.getElementsByTagName("baseAvoidAttacks").item(0).getTextContent());
      int baseThreat = Integer.parseInt(elementStats.getElementsByTagName("baseThreat").item(0).getTextContent());

      CombatStats combatStats = new CombatStats(health, armor, baseAttack, baseAvoid, baseThreat);

      // 3. Stats de clase
      Element elementClass = (Element) elementPlayer.getElementsByTagName("class").item(0);
      String className = elementClass.getAttribute("kind");

      if (className.equals("Warrior")) {
        int statShield = Integer.parseInt(elementClass.getElementsByTagName("statShield").item(0).getTextContent());
        int probBlock = Integer
            .parseInt(elementClass.getElementsByTagName("probabilityBlock").item(0).getTextContent());

        Warrior warrior = new Warrior(combatStats, statShield, probBlock);
        players[i] = new Player(name, race, warrior);
      }
    }
    return players;
  }

}
