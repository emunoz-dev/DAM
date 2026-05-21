

public class Application {
  public static void main(String[] args) throws MyException {
    Application app = new Application();
    
    try {
      if (args.length > 0 ) {
        switch (args[0]) {
          case "-M", "--map":
            break;
          case "-L", "--list":
            ReadXML reading = new ReadXML(args[0]);
            reading.printCars(args[0]);            
            break;
          case "-A", "--array":
            System.out.println("Can not used to because is necesary known the size before process logic.");
            break;
          case "-h", "--help":
            app.funcHelp();
            break;
          default:
            break;
        }
      }
      
      //reading.readFile(); // Software needs to executed from root directory of git project
    } catch (MyException e) {
      e.printStackTrace();
    }

    
    
  }

  public void funcHelp() {
    System.out.println("###########################################");
    System.out.println("-M | --map:\t Data structure HashMap");
    System.out.println("-L | --list:\t Data structure ArrayList");
    System.out.println("-A | --array:\t Data structure Array");
    System.out.println("-h | --help:\t How to use");
    System.out.println("###########################################");
  }
}
