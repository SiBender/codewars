public class Dinglemouse {
  private static int max;
  private static int[][] myDigitalArr;
  public static int peakHeight(char[][] mountain) {
    max = 0;
    int height = mountain.length;
    int width = mountain[0].length;
    myDigitalArr = new int[height][width];
    
    for (int i = 0; i < height; i++){
      for (int j = 0; j < width; j++){
        myDigitalArr[i][j] = (mountain[i][j] == '^') ?  0 : -1;
      }
    }
    
    int[] neighbors = new int[4];

    for (int i = 0; i < height; i++){
      for (int j = 0; j < width; j++){
        if(myDigitalArr[i][j] != 0) {continue;}
        if(i == 0 || j == 0 || i == height - 1 || j == width - 1){
          myDigitalArr[i][j] = 1;
          max = 1;
          continue ;
        }
        neighbors[0] = myDigitalArr[i][j-1];
        neighbors[1] = myDigitalArr[i][j+1];
        neighbors[2] = myDigitalArr[i-1][j];
        neighbors[3] = myDigitalArr[i+1][j];
        myDigitalArr[i][j] = checkForContour(neighbors);  
      }
    }

    boolean finished = false;
    int nextHeight = 1;
    while(finished == false){
      finished = true;
      nextHeight++;
      for (int i = 0; i < height; i++){
        for (int j = 0; j < width; j++){
          if(myDigitalArr[i][j] != 0) {continue;}
          finished = false;
          neighbors[0] = myDigitalArr[i][j-1];
          neighbors[1] = myDigitalArr[i][j+1];
          neighbors[2] = myDigitalArr[i-1][j];
          neighbors[3] = myDigitalArr[i+1][j];
          myDigitalArr[i][j] = testDigitN(neighbors,nextHeight);   
        }
      }
    }
    return max;
  }
  
  private static int checkForContour(int[] arr){
    for(int n : arr){
      if (n == -1){
        max = 1;
        return 1;
      }
    }
    return 0;
  }
  
  private static int testDigitN(int[] arr, int next){
    int tempMin = 10000;
  
    for(int n : arr){
     if(n == 0) {continue;}
     if(n < tempMin) {tempMin = n;}  
    }
    int nextVal = tempMin+1;
    if (tempMin+1 > next) {return 0;}
    max = next;
    return next;
  }
}
