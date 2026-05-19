public class MyException extends Exception {
  private static String myErrorOut;
  private static int codeError;

  public MyException(int inCode, Throwable soureCause) {
    super(generateError(inCode), soureCause);
  }

  private static String generateError(int inCode) {
    switch (inCode) {
      case 100:
        myErrorOut = inCode + ":\t Number of args is wrong";
        break;
      default:
        break;
    }
    return myErrorOut;
  }
  
  
}
