public class MyExceptions extends Exception {
  String myErrorOut;
  //StackTraceElement[]

  public MyExceptions(int codeError, StackTraceElement[] traceSource) {
    
    switch (codeError) {
      case 100:
        this.myErrorOut = "Number of args is wrong";
        printMyError(traceSource);
        break;
    
      default:
        break;
    }
  }

  public void printMyError(StackTraceElement[] traceSource) {
    if (traceSource != null) {
      for (int i = 0; i < traceSource.length; i++) {
        this.myErrorOut += traceSource[i].toString();
      }
    }
    System.out.println(myErrorOut);
  }
}
