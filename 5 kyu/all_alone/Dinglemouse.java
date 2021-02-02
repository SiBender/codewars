import java.util.*;

public class Dinglemouse {
  public static boolean isAlone;
  public static char[][] myHouse;
  
  public static boolean allAlone(char[][] house) {
    isAlone = true;
    myHouse = house.clone();
    int height = myHouse.length;
    int width = myHouse[0].length;
    int[] xPoint = new int[2];
    System.out.println("Height:"+height);
    System.out.println("Width:"+width);// Your code here

    breakall:
    for(int x = 0; x < height; x++){
      for(int y = 0; y < width; y++){
        if(myHouse[x][y] == 'X'){
          xPoint[0] = x;
          xPoint[1] = y;
          
          System.out.format("xPoint[%d:%d]",x,y);
          break breakall;
        }
      }
    }
    
    List<int[]> newNeighbours = new ArrayList<>();
    newNeighbours.add(xPoint);
    markRecurs(newNeighbours);

    return isAlone;
  }

 
    public static void markRecurs(List<int[]> points){
    List<int[]> neighbours = new ArrayList<>();
    int x,y;
    if (points.size() == 0 || isAlone == false) {return;}

    for(int[] p : points){
      for(int i = -1; i <= 1; i++){
        for(int j = -1; j <=1; j++){
          x = p[0]+i;
          y = p[1]+j;
          if(myHouse[x][y]== 'o'){isAlone = false;}
          if(myHouse[x][y]== ' '){
            int[] nextPoint = {x,y};
            neighbours.add(nextPoint);
            myHouse[x][y] = 'X';
          }
        }
       }
     } 
    //showHouse();
    markRecurs(neighbours);
  }
  
  public static void showHouse(){
    System.out.println();
    for(char[] str : myHouse){
      for(char ch : str){
        System.out.print(ch);
      }
      System.out.println();
    }
  }

}
