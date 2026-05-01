package src;

import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Application {

  public static void main(String args[]) {
    Application ap = new Application();
    try {
      ap.optionsArgs(args);
    } catch (myErrors e) {
      System.out.println(e.getErrorM());
    }
  }

  public void optionsArgs(String args[])  throws myErrors {
    int aux = -1;
    int sz;

    WatchStrokes wStr [];
    List<WatchStrokes> mList = new ArrayList<>();
    Map<Integer, WatchStrokes> mHashMap = new HashMap<>();

    boolean A = false, L = false, M = false;
    
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-A" : // Array
          aux = i + 1; // This parameter of arg
          i++; // Skip of next argument because might be a parameter of this arg
          try {
            sz = Integer.parseInt(args[aux]);
            wStr = new WatchStrokes[sz];
            for (int x = 0; x < wStr.length; x++) {
              WatchStrokes wAux = new WatchStrokes();
              wStr[x] = wAux.inOut(); 
            }
          } catch (NumberFormatException e) {
            throw new myErrors(102, e.getStackTrace()) ;
          }      
          break;
        case "-L": // List Array (vector)
          aux = i + 1; // This parameter of arg
          i++; // Skip of next argument because might be a parameter of this arg
            
          try {
            sz = Integer.parseInt(args[aux]);
          } catch (NumberFormatException e) {
            throw new myErrors(102, e.getStackTrace()) ;
          }
          for (int x = 0; x < sz; x++) {
            WatchStrokes wAux = new WatchStrokes();
            mList.add(wAux.inOut());
          }
          L = true; // List array completed
          break;
        case "-M": // Map
          aux = i + 1; // This parameter of arg
          i++; // Skip of next argument because might be a parameter of this arg
          try {
            sz = Integer.parseInt(args[aux]);
          } catch (NumberFormatException e) {
            throw new myErrors(102, e.getStackTrace());
          }
          for (int x = 0; x < sz; x++) {
            WatchStrokes wAux = new WatchStrokes();
            
            mHashMap.put(wAux.hashCode(), wAux.inOut());
          }  
          break;
        case "-l": // list values of object created
          if (L) {
            for (WatchStrokes item : mList) {
              item.printWatchStrokes();
            }
          }

          if (M) {
            // Legacy way to print
            for (Map.Entry<Integer, WatchStrokes> iMap : mHashMap.entrySet() ) {
              iMap.getValue().printWatchStrokes();
            }
            /* Lamba expression , new way to print 
            // mHashMap.forEach((key, value) -> value.printWatchStrokes() );
            */
          }
          
          break;
        default:
          if (aux == -1) {
            throw new myErrors(101, null);
          }
        }
    }
  }
}