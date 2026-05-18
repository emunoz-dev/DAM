import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class Category {
  private String category;

  private Map<Integer, Game> g = new HashMap<>();

  public Category(String category) {
    this.category = category;
  }

  public Map<Integer, Game> getGames() {
    return this.g;
  }

  public void addGame(Integer id, Game game) {
    g.put(null, game);
  }

}
