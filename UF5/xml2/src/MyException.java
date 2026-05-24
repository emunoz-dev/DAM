public class MyException extends Exception {
  private static String myError;
  private static int codeError;

  public MyException(int inCode, Throwable causeSource) {
    super(generatorError(inCode) , causeSource);
  }


  private static String generatorError(int inCode) {
    switch (inCode) {
      case 100:
        codeError = inCode;
        myError = codeError + ":\t The file can't read";
        break;
      case 101:
        codeError = inCode;
        myError = codeError + ":\t The file wasn't load into memory";
        break;
    
      default:
        break;
    }
    return myError;
  }
}
