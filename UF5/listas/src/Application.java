import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {

  public static void main(String[] args) throws MyException {
    final String FIN = "FIN";
    Scanner sc = new Scanner(System.in);
    String inputCategory = null;
    String [] inputGame = new String[5];
    String auxInputGame = "";
    List <String> categorys = new ArrayList<>(); 
    List <Category> categoryList = new ArrayList<>();
    
    while (! FIN.equals(inputCategory)) {
      inputCategory = null;
      System.out.println("Enter category of game:");
      inputCategory = sc.next();
      sc.nextLine();

      while (! FIN.equals(inputCategory) && !auxInputGame.equals(FIN) ) {
        auxInputGame = "";
        categorys.add(inputCategory);
        Category categoryAux = new Category( categorys.get(categorys.size() - 1) );
        categoryList.add(categoryAux);
        System.out.println("Enter a game with format:");
        System.out.println("ID\t local team + points game\t visitor team + points game");
        auxInputGame = sc.nextLine();
        try {
          inputGame = auxInputGame.split("\s");
        } catch (Exception e) {
          //e.printStackTrace();
          throw new MyException(100, e ); // Over args
          
        }
        if (inputGame.length < 5) {
          throw new MyException(100, null);
        }
      
        if (inputGame.length == 5 && !inputGame[0].equals(FIN)) {
          int auxId = Integer.parseInt(inputGame[0]);
          byte auxLocalPoints = Byte.parseByte(inputGame[2]);
          byte auxVisitorPoints = Byte.parseByte(inputGame[4]);
          Game auxGame = new Game(auxId, inputGame[1], auxLocalPoints, inputGame[3], auxVisitorPoints);
          categoryList.get(categoryList.size() -1).addGame(auxGame); //Last cetegory
        }
        
      }
      for (Category auxCategory : categoryList) {
        auxCategory.sortingId();
        for (Game auxGames : auxCategory.getGames()) {
          System.out.println(auxGames.getIdGames());
        }
      }

    }
    
  }
  
}
