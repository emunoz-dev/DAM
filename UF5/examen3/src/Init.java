public class Init {
  public static void main(String[] args) {
    Input input = new Input();
    switch (args[0]) {
      case "-A":
        break;
      case "-M":
        break;
      case "-L":
        break;
    
      default:
        break;
    }

    try {
      input.data();
    } catch (MyException me) {
      me.printStackTrace();
    }
    
    
  }
}
