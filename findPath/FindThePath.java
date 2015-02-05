import java.util.*;
import java.io.*;

public class FindThePath {

  static int endx, endy;
  static int width = 0, height = 0;

  public static void main(String[] args) throws Exception {

    Scanner counter = new Scanner(new File("input.txt"));

    counter.nextLine();
    width = counter.nextLine().length();
    height++;

    while( counter.hasNext() ){
      counter.nextLine();
      height++;
    }
    
    counter.close();
    //System.out.printf( "Height: %d, Width: %d\n", height, width);

    char[][] c = new char[height][width];

    Scanner scn = new Scanner(new File("input.txt"));
      
    String pattern = scn.nextLine();
    for( int i = 0; i < height && scn.hasNext(); i++) {
      String tmp = scn.nextLine();
      c[i] = tmp.toCharArray();
    }

    scn.close();

    endx = width - 1;
    endy = height - 1;

    String path = findPath( c, 0, 0, pattern.substring(1), "");

    printGrid( path, pattern);

  }

  static String findPath( char[][] c, int x, int y, String s, String path) {
    //System.out.printf("(%d,%d)\t%s\n", y, x, s); 
    if (x == endx && y == endy)
      return path;
    if (s.length() == 0) return "";
    if ( x > endx || y > endy || x < 0 || y < 0 ) return "";

    
    boolean[] validPath = new boolean[4];
    validPath[0] = y != 0     && c[y-1][x]==s.charAt(0);
    validPath[1] = x != endx  && c[y][x+1]==s.charAt(0);
    validPath[2] = y != endy  && c[y+1][x]==s.charAt(0);
    validPath[3] = x != 0     && c[y][x-1]==s.charAt(0);

    c[y][x] = '#';

    String r = "";
    for (int i = 0; i < 4; i++) {
      if (validPath[i]) {
        r += findPath(  c,
                        xFromDir(i,x),
                        yFromDir(i,y),
                        s.substring(1),
                        path + i);

      }
    }
      
    return r;
  }

  static int xFromDir( int direction, int x){

    switch ( direction ) {
      case 1:
        return x+1;
      case 3:
        return x-1;
      default:
        return x;
    }

  }
  
  static int yFromDir( int direction, int y){

    switch ( direction ) {
      case 0:
        return y-1;
      case 2:
        return y+1;
      default:
        return y;
    }

  }


  static void printGrid( String path, String pattern){
    char[][] c = new char[height][width];
    for ( int i = 0; i < height; i++ )
      for ( int j = 0; j < width; j++ )
        c[i][j] = '.';

    char[] p = path.toCharArray();
  
    int y=0,x=0;
    for ( int i = 0; i < p.length; i++) {
      c[y][x] = pattern.charAt(i);
      switch (p[i]) {
        case '0':
          y -= 1;
          break;
        case '1':
          x += 1;
          break;
        case '2':
          y += 1;
          break;
        case '3':
          x -= 1;
          break;
      }
    }
    if ( p.length > 0 ) c[endy][endx]=pattern.charAt(pattern.length()-1);
    for ( int i = 0; i < height; i++ ) {
      for ( int j = 0; j < width; j++ )
        System.out.print(c[i][j]);
      System.out.println();
    }
  }

}
