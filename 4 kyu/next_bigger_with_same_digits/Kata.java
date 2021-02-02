import java.util.*;

public class Kata{
 
    public static ArrayList<Long> makeNumArray(long num){
      ArrayList<Long> numArray = new ArrayList<Long>();
      while(num > 0){
        numArray.add(num % 10);
        num /= 10;
      }
      return numArray;
    }
    
    public static long nextBiggerNumber(long n)
    {
      System.out.println(n);
      ArrayList<Long> nums = makeNumArray(n);
      long breakNum;
      int shortArrayLen = 0;
      ArrayList<Long> shortArray = new ArrayList<Long>();
      
      for(int i = 0; i < nums.size() - 1; i++){
        if (nums.get(i+1) < nums.get(i)){
          breakNum = nums.get(i+1);
          shortArrayLen = i+1;
          for (int j = 0; j < i+1; j++){
            if (nums.get(j) > breakNum) {
              nums.set(i+1, nums.get(j)); 
              nums.set(j, breakNum);
              break;
            }
          }
          for (int x = 0 ; x < shortArrayLen; x++){
            shortArray.add(nums.get(shortArrayLen-x-1));
          }
          
          break;
        }
      }
      
      for(int y = 0; y < shortArray.size(); y++){
        nums.set(y, shortArray.get(y));
      }
      

      long nextBigger = 0L;
      for(int i = nums.size()-1 ; i >=0; i--){
        nextBigger *= 10;
        nextBigger += nums.get(i);
      }
      if (nextBigger <= n) {return -1L;}
      return nextBigger;
    }
}
