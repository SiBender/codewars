public class Solution {
  public static int zeros(int n) {
      System.out.println(n);
      if(n == 0){return 0;}
      
      int count = 0;
      int x = 0;
      int start = (n/25)*25;
      for(int i = start; i > 0; i= i -25){
        x = i;
        count += 4;
        /*while(x % 10 == 0) {
          x=x/10;
          count++;
          }*/
        while(x % 5 == 0){
          x=x/5;
          count++;}
        }
        
        for (int j = start+1; j <= n ; j++){
          //System.out.println("in cicle:" +j);
          x= j;
          while(x % 5 == 0){
            x=x/5;
            count++;
          }
         }
        
      //count = count +     
     
      return count;
  }
}
