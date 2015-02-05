import java.io.*;
import java.util.*;

public class VendingMachine {

  private static HashMap<String, Candy> inventory = new HashMap<String, Candy>();
  private static ArrayList<ChangeSlot> changeslot = new ArrayList<ChangeSlot>();





  public static void main(String [] args) throws Exception {

    ArrayList<String> contents = new ArrayList<String>();
    Scanner fp = new Scanner(new File("input.txt")).useDelimeter(",");
    while ( fp.hasNext() ) {
      String buf = fp.next();
      if ( buf.charAt(0) == '$' ) {

      }
      else if ( buf.equals("Actions") ) {

      }
      else {
        String id = buf;
        c = new Candy();
        c.name = fp.next();
        c.cost = fp.nextDouble();
        c.quantity = fp.nextInt();
        inventory.put(id, c);
      }

    }
    fp.close();

    System.out.println(contents);

  }
}

class Candy {
  public String name;
  public double cost;
  public int quantity;
}

class ChangeSlot implements Comparable<ChangeSlot> {
  public int slot;
  public int val;
  public int quantity;
  int compareTo( ChangeSlot other ) {
    if (other.val == this.val) return 0;
    return this.val < other.val ? -1 : 1;
  }
}
