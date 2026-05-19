
public class Application {
  public static void main(String[] args) throws MyException {
    Application app = new Application();
    ReadXML reading = new ReadXML();
    try {
      reading.readFile(); // Software needs to executed from root directory of git project
    } catch (MyException e) {
      e.printStackTrace();
    }

    if (args.length > 0 ) {
      switch (args[0]) {
        case "-M", "--map":
          break;
        case "-h", "--help":
          app.funcHelp();
          break;
        default:
          break;
      }
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
