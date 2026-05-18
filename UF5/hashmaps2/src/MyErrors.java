import java.lang.StackTraceElement;

public class MyErrors extends Exception {

  String myError;

  public MyErrors(int code, StackTraceElement[] traceError) {
    switch (code) {
      case 100:
        this.myError = "The input is wrong\n";
        manageTrace(traceError);
        break;
      case 101:
        this.myError = "The number is different to total names introduced. The input is wrong\n" ;
        manageTrace(traceError);
      case 102:
        this.myError = "The number of sucessors should be greatter 1";
        manageTrace(traceError);
      default:
        break;
    }
  }

  public void manageTrace(StackTraceElement[] traceError) {
    if (traceError != null) {
      for (int i = 0; i < traceError.length; i++) {
        this.myError += traceError[i].toString() + "\n";
      }
    }
    System.out.println(this.myError);
  }

}
