import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.Map;
import java.util.HashMap;

public class Application {
  Map<Integer,Dynasty> mapDynasty = new HashMap<Integer, Dynasty>();
  public static void main(String[] args) {
    Application app = new Application();
    try {
      app.inputData();
      app.outputData();
    } catch (MyException e) {
      e.printStackTrace();
    }
    
  }

  public void inputData() throws MyException {
    Scanner sc = new Scanner(System.in);
    String inputD; String[] namesKings, namesSuccesors;
    int inNumKings = -1, inNumSucc = -1;
    int codeDynasty;

    while (inNumKings != 0) {
      inNumKings = -1;
      inNumSucc = -1;
      System.out.println("Input the number of kings on dynasty:");
      try {
        inNumKings = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        throw new MyException(100, e );
      }

      if (inNumKings != 0) {
        System.out.println("Input the names of all kings on dynasty, separated by spaces");
        inputD = sc.nextLine();
        namesKings = inputD.split("\s");
        if (inNumKings != namesKings.length ) {
          throw new MyException(101, null);
        }
        inputD = null; // Clean
        System.out.println("Input the number of successor to the frost trhone:");
        try {
          inNumSucc = sc.nextInt();
          sc.nextLine();
        } catch (InputMismatchException e) {
          throw new MyException(100, e );
        }
        if (inNumSucc < 1) {
          throw new MyException(102, null);
        }
        System.out.println("Input the names of all sucessors on dynasty, separated by spaces");
        inputD = sc.nextLine();
        namesSuccesors= inputD.split("\s");
        if (inNumSucc != namesSuccesors.length ) {
          throw new MyException(101, null);
        }


        Dynasty auxDynasty = new Dynasty(inNumKings, namesKings, inNumSucc, namesSuccesors);
        codeDynasty = auxDynasty.hashCode();
        

        mapDynasty.put(codeDynasty, auxDynasty);

      }
      
    } 
  }

  public void outputData() {

    for (Map.Entry<Integer, Dynasty> auxMap : mapDynasty.entrySet() ) {
      System.out.println("The code of dynasty is:");
      System.out.println(auxMap.getKey());
      //System.out.println(auxMap.getValue().numKings);
    }

  }

  public Dynasty getDynastyByKey(Integer inId) {
    return mapDynasty.get(inId);
  }
}
