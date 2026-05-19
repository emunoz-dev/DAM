package src;

//import java.lang.Exception;

public class MyException extends Exception {
  private static int errorCode = 0;
  private static String errorM;

  
  public MyException(int errorCode, Throwable cause) {
    super(construcMyException(errorCode), cause);
  }

  private static String construcMyException(int inCode) {
    
    switch (inCode) {
      case 10:
        errorCode = inCode;
        errorM = errorCode + ":\t Data input is wrong";
        break;
      case 101:
          errorCode = inCode;
          errorM = errorCode + ":\t The argument is wrong";
        break;
      case 102:
          errorCode = inCode;
          errorM = errorCode + ":\t The value of argument is wrong";
        break;
      case 11:
        errorCode = inCode;
        errorM = errorCode + ":\t The times are equal. Data input is wrong";
        break;
      
      default:
        errorCode = inCode;
        errorM = errorCode + ":\t This error is unkown and don't manage it";
        break;
    }

    return errorM;
  }
}
