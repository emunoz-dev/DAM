public class MyException extends Exception {
  private static String myError;
  private static int codeError;
    
  public MyException(int code, Throwable cause) {
    super(construcMyError(code), cause);
  }

  private static String construcMyError(int inCode) {
    switch (inCode) {
      case 100:
        codeError = inCode;
        myError = codeError + ":\t The input should be an integer\n";
        break;
      case 101:
        codeError = inCode;
        myError = codeError + ":\t Error: The number required should be greatter than 1\n";
      default:
        break;
    }
    return myError;
  }
  
  
}
