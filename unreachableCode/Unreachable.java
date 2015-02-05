import java.io.*;
import java.util.*;

public class Unreachable {
  public static void main(String [] args) {

    ArrayList<String> contents = new ArrayList<String>();
    try {
      Scanner fp = new Scanner(new File("input.txt"));
      while ( fp.hasNext() ) contents.add(fp.nextLine());
      fp.close();
    } catch ( Exception e ) {
      e.printStackTrace();
      System.exit(1);
    }

    boolean [] reached = new boolean[contents.size()];

    int i = 0;
    int j = 0;
    boolean amnesty = true;

    while ( i < contents.size() && j < contents.size() ) {

      reached[i] = true;
      reached[j] = true;

      if ( i == j && !amnesty) break;
      if ( amnesty ) amnesty = false;

      if ( contents.get(i).equals("NEXT") ) i++;
      else i = Integer.parseInt(contents.get(i).substring(5)) - 1;

      if ( contents.get(j).equals("NEXT") ) j++;
      else j = Integer.parseInt(contents.get(j).substring(5)) - 1;
      reached[j] = true;
      if ( contents.get(j).equals("NEXT") ) j++;
      else j = Integer.parseInt(contents.get(j).substring(5)) - 1;
       
    }

    for ( int k = 0; k < reached.length; k++) 
      if ( !reached[k] ) System.out.println(k + 1);

  }

}
