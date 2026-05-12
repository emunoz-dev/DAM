import java.util.List;
import java.util.ArrayList;

public class Category {
  private String category;

  private List <Game> g = new ArrayList<Game>();

  public Category(String category) {
    this.category = category;
  }

  public void addGame(Game game) {
    g.add(game);
  }

  /* 
  1. I have a local players and visitors players
    1.1 Control there are players equals in local and visitors
      - Find players
  2. sum result of both games
  3. Return who is winner
  */ 
  
}
