import java.util.Scanner;

public class Input {
  Scanner in = new Scanner(System.in);
  int n = -1;
  
  public void data() throws MyExceptions {
    while ( n != 0) {
      System.out.println("- Enter a positive number. It's digits numbers to calculate how much reverse numbers is posible");
      System.out.println("- Enter 0 to exit");
      try {
        n = in.nextInt();
      } catch (Exception e) {
        throw new MyExceptions(100, e.getStackTrace());
      }
      if (n == 1) {
        throw new MyExceptions(101, null);
      }
    } 
  }
  /*while (in) {

  }*/
}
