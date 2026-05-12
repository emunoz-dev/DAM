import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {

  public static void main(String[] args) {
    final String FIN = "FIN";
    Scanner sc = new Scanner(System.in);
    String input = null;

    List <String> categorys = new ArrayList<>(); 
    List <Category> categoryList = new ArrayList<>();
    while (! FIN.equals(input)) {
      input = null;
      System.out.println("Enter category of game:");
      input = sc.next();
      
      if (! FIN.equals(input)) {
        categorys.add(input);
        Category categoryAux = new Category( categorys.get(categorys.size() - 1) );
        categoryList.add(categoryAux);
      }
      sc.nextLine();
    }
    
  }
  
}
