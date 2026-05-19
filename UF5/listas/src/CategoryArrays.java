
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CategoryArrays {
  private String category;

  private Game[] g;
  private int gameLenght;

  public Comparator<Game> idComparator = new Comparator<Game>() {
    @Override
    public int compare(Game g1, Game g2) {
      return g1.getIdGames() - g2.getIdGames();
    }
  };

  public CategoryArrays(String category, int gameLenght) {
    this.category = category;
    this.gameLenght = gameLenght;

    g = new Game[gameLenght];
  }

  public Game[] getGames() {
    return this.g;
  }

  public void addGame(Game game) {
    for (int i = 0; i < this.g.length ; i++) {
      if (this.g[i] == null) {
        this.g[i] = game;
      }
    }
  }

  

  public void sortingId() {
    //Comparator<Game> idComparator = (g1, g2) ->  g2.getIdGames() - g1.getIdGames();
    
    Arrays.sort(this.g, idComparator);
  }

  public int searchId(int auxId) {
    int posFind = -1;

    sortingId();
    Game auxGame = new Game(auxId);
    posFind = Arrays.binarySearch(this.g , auxGame, idComparator);
    return posFind;
  }

  public void returnGames() {
    for ( Game itemGame : getGames() ) {
      System.out.println(itemGame.getIdGames());
    }
  }
}
