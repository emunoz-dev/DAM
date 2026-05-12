public class MyExceptions extends Exception {
  String myError;
  StackTraceElement[] trace;
    
  public MyExceptions(int code, StackTraceElement[] trace) {
    switch (code) {
      case 100:
        this.myError = "The input should be an integer\n";
        this.trace = trace;
        break;
      case 101:
        this.myError = "Error: The number required should be greatter than 1\n";
      default:
        break;
    }
  }
  
  public void printMyError() {
    if (this.trace != null) {
      for (int i = 0; i < this.trace.length; i++ ) {
        this.myError += trace[i].toString() + "\n";
      }
    }
    
    System.out.println(myError);
  }
}
