public class Snail {
    private static int left,right,top,bottom;
    public static int[] snail(int[][] array) {
      left = 0;
      right = array[0].length - 1;
      top = 0;
      bottom = array[0].length - 1;
      
      int count = array[0].length*array[0].length;
      int[] out = new int[count];
      int pos = 0;
      int i = 0; // vertical coordinate
      int j = 0; // horizontal coordinate
      while(count >0){
        i=top;
        j=left;        
        //move right
        while(j <= right){
          out[pos] = array[i][j];
          pos++;
          count--;
          j++;
        }
        top++;
        i=top;
        j=right;
      
        //move down
        while(i <= bottom){
          out[pos] = array[i][j];
          pos++;
          count--;
          i++;  
        }
        right--;
        i=bottom;
        j=right;

        //move left
        while(j>=left){
          out[pos] = array[i][j];
          pos++;
          count--;
          j--;            
        }
        bottom--;
        i=bottom;
        j=left;

        //move up
        while(i>=top){
          out[pos] = array[i][j];
          pos++;
          count--;
          i--;  
        }
        left++;
        j=left;
        i=top;
      }

     return out;
   } 
}
