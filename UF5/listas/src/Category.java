import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Category {
  private String category;

  private List<Game> g = new ArrayList<Game>();

  public Category(String category) {
    this.category = category;
  }

  public List<Game> getGames() {
    return this.g;
  }

  public void addGame(Game game) {
    g.add(game);
  }

  public void sortingId() {
    //Comparator<Game> idComparator = (g1, g2) ->  g2.getIdGames() - g1.getIdGames();
    Comparator<Game> idComparator = new Comparator<Game>() {
      @Override
      public int compare(Game g1, Game g2) {
        return g1.getIdGames() - g2.getIdGames();
      }
    };
    Collections.sort(this.g, idComparator);
  }
}
