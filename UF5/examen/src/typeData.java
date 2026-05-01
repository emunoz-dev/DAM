package src;

import java.util.ArrayList;
import java.util.HashMap;

public class typeData {
  public static void main(String[] args) {
    typeData td = new typeData();
    td.arrayF();
  }

  // Array data types
  public void arrayF() {
    int[] nm;
    nm = new int[3];
    for (int i = 0; i < nm.length; i++) {
      nm[i] = i + 1;
    }
    for (int i = 0; i < nm.length; i++) {
      System.out.println(nm[i]);
    }
  }

  // ArrayList data types
  public void arrayL() {
    ArrayList<Integer> nm;
    nm = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      nm.add(i + 1);
    }
    for (int i = 0; i < nm.size(); i++) {
      System.out.println(nm.get(i));
    }
  }

  // HashMap data types
  public void hashM() {
    HashMap<String, Integer> nm;
    nm = new HashMap<>();
    nm.put("one", 1);
    nm.put("two", 2);
    nm.put("three", 3);
    for (int i = 0; i < nm.size(); i++) {
      System.out.println(nm.get(i));
    }
  }

}