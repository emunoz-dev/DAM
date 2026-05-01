package src;

import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
// Exceptions
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class WatchStrokes {

  LocalTime f1time , f2time;
  int nStroke, tStroke;

  public void setf1time() {
    try {
      this.f1time = inputTimes();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public void setf2time() {
    try {
      this.f2time = inputTimes();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
   
  public void setnStroke() {
    try {
      this.nStroke = inputStrokes();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public void settStroke() {
    try {
      this.tStroke = inputStrokes();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public WatchStrokes inOut() {
     System.out.println("Enter time that the watch does stroke and enter time that the watch does the last stroke\n");
    try {
      System.out.println("Enter time that does firts stroke. Format input: HH:MM:SS\n");
      setf1time();
      //this.f1time = inputTimes(); 
      System.out.println("Enter second time that does last stroke. Format input: HH:MM:SS\n");
      setf2time();
      //this.f2time = inputTimes();
      if (this.f1time.equals(this.f2time)) {
        throw new myErrors(11, null); // The time can't be equal
      }

      System.out.println("Enter the total number of strokes that will sound:");
      setnStroke();
      //this.nStroke = inputStrokes();
      System.out.println("Enter the number stroke that you want known the time of stroke sounds:");
      settStroke();
      //this.tStroke = inputStrokes();

      printWatchStrokes();
      
    } catch (myErrors e) {
      System.out.print(e.getErrorM());
    }
    return this;
  }

  public void printWatchStrokes() {
    System.out.println("The moment does stroke is:");

    System.out.println(calcTimeInit(this.f1time, this.f2time, this.nStroke, this.tStroke));
  }

  public LocalTime inputTimes() throws myErrors, InputMismatchException {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime tm;
    String inTime;

    Scanner sc = new Scanner(System.in);
    try {
      inTime = sc.nextLine();
      tm = LocalTime.parse(inTime, dtf);



    } catch (DateTimeParseException e) {
      sc.close();
      throw new myErrors(10, e.getStackTrace() );
    }

    sc = null; dtf = null; inTime = null;
    return tm;
  }

  public int inputStrokes() throws myErrors {
    Scanner sc = new Scanner(System.in);
    int stroke;
    
    try {
      stroke = sc.nextInt();
    } catch (InputMismatchException e) {
      throw new myErrors(10, e.getStackTrace());
    }

    sc = null;
    return stroke;
  }
  
  public String calcTimeInit(LocalTime t1, LocalTime t2, int totalStroke, int whatStroke) {
    long totalS, eachStroke, momentStroke = 0;
    Duration[] tms = new Duration[totalStroke]; // Because position 0 is firtst stroke
    Duration durationT;
    String timedQuery = null;

    durationT = Duration.between(t1, t2);
    if (t2.isBefore(t1)) {
      durationT = durationT.plusHours(24);
    }

    totalS =  durationT.toSeconds(); //ChronoUnit.SECONDS.between(t1, t2);

    eachStroke = totalS / totalStroke;

    // Make an array Duration named tms with totalStroke lengh
    for (int i = 0; i < tms.length ; i++) {
      // each value momentStroke is =+ eachStroke in format Duration
      momentStroke =++ eachStroke;
      tms[i] = Duration.ofSeconds(momentStroke);
      if ( i == whatStroke - 1) {
        timedQuery = tms[i].toHours() +  ":" + tms[i].toMinutesPart() + ":" + tms[i].toSecondsPart();
      }
    }
    tms = null;
    return timedQuery;
  }
}
