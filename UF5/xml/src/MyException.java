public class MyException extends Exception {
  private static String outError;
  private static int code;

  public MyException(int inCode, Throwable sourceCause) {
    super(constructString(inCode), sourceCause);

  }

  private static String constructString(int inCode) {
    switch (inCode) {
      case 100:
        code = inCode;
        outError = code + ":\t The file can't loaded into memory \n";
        break;
      case 101:
        outError = "The file can't loaded into memory \n";
        break;

      default:
        break;
    }
    return outError;
  }
}
