import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Category {
  private String category;

  private List<Game> g = new ArrayList<>();
  public Comparator<Game> idComparator = new Comparator<Game>() {
    @Override
    public int compare(Game g1, Game g2) {
      return g1.getIdGames() - g2.getIdGames();
    }
  };

  public Category(String category) {
    this.category = category;
  }

  public List<Game> getGames() {
    return this.g;
  }

  public void addGame(Game game) {
    g.add(game);
  }

  public void deleteGame(Game game) {
    int posDelete = -1;

    posDelete = searchId(game.getIdGames());
    g.remove(posDelete);
  }

  public void sortingId() {
    //Comparator<Game> idComparator = (g1, g2) ->  g2.getIdGames() - g1.getIdGames();
    
    //Collections.sort(this.g, idComparator);
    Collections.sort(this.g , idComparator);
  }

  public int searchId(int auxId) {
    int posFind = -1;

    sortingId();
    Game auxGame = new Game(auxId);
    posFind = Collections.binarySearch(this.g , auxGame, idComparator);
    return posFind;
  }

  public void returnGames() {
    for ( Game itemGame : getGames() ) {
      System.out.println(itemGame.getIdGames());
    }
  }

  public void returnGameById (int inId) {
    int pos = searchId(inId);

    System.out.print(this.g.get(pos).getHouse() );
  }
}
