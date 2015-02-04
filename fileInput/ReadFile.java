import java.io.*;
import java.util.*;

public class ReadFile {
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

    System.out.println(contents);

  }
}
