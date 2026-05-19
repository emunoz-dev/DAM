
public class MyException extends Exception {

  private static String myError;
  private static int codeError;

  public MyException (int inCode, Throwable sourceCause) {
    super(constructMyError(inCode), sourceCause);
  }

  public static String constructMyError(int inCode) {
    switch (inCode) {
      case 100:
        codeError = inCode;
        myError = codeError + ":\t The input is wrong\n";
        break;
      case 101:
        codeError = inCode;
        myError = codeError + ":\t The number is different to total names introduced. The input is wrong\n" ;
      case 102:
        codeError = inCode;
        myError = codeError + ":\t The number of sucessors should be greatter 1";
      default:
        break;
    }
    return myError;
  }

}
