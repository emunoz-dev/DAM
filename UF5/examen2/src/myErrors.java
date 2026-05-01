package src;

import java.lang.Exception;

public class myErrors extends Exception {
  private int errorCode = 0;
  private String errorM = "Not error";
  private StackTraceElement[] TraceE;

  
  public myErrors(int errorCode, StackTraceElement[] TraceE) {
    this.errorCode = errorCode;
    this.TraceE = TraceE;
    //this.TraceE = TraceE;
    switch (errorCode) {
      case 10:
        this.errorM = "Data input is wrong";
        break;
      case 101:
         this.errorM = "The argument is wrong";
        break;
      case 102:
         this.errorM = "The value of argument is wrong";
        break;
      case 11:
        this.errorM = "The times are equal. Data input is wrong";
        break;
      
      default:
        this.errorM = "This error is unkown and don't manage it";
        break;
    }
  }

  public String getErrorM() {
    String mOut = "Error code: " + this.errorCode + ":\t\t" + this.errorM + " \n" ;
    
    if (TraceE != null) {
      for (int i = 0; i < TraceE.length; i++) {
        mOut += TraceE[i].toString() + "\n";
      }
    }
    
    return  mOut;
  }
}
