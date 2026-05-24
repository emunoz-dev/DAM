import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

public class Raid {

  private Map<String, Player> raid = new HashMap<>();

  public Raid() {
    ReadXmlRaid readXmlRaid = new ReadXmlRaid();
    try {
      Document docXmlRaid = readXmlRaid.loadDocumentXml();
      Player[] players = readXmlRaid.makePlayers(docXmlRaid);
      for (Player player : players) {
        this.raid.put(player.getName(), player);
      }
    } catch (MyException e) {
      e.printStackTrace();
    }
  }

  public void addPlayer(String name, Player player) {
    this.raid.put(player.getName(), player);
  }

  public Player getPlayer(String name) {
    return this.raid.get(name);
  }

  public void removePlayer(String name) {
    this.raid.remove(name);
  }

  public void printRaid() {
    for (Player player : this.raid.values()) {
      System.out.println(player.getName() + " " + player.getRace() + " " + player.getClassPlayer());
    }
  }

}
