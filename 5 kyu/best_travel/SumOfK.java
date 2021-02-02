import java.util.*;

public class SumOfK {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
    System.out.println("in recursion:"+ t +":"+k+":"+ls.toString()); 
      if (ls.size() < 1) {return null;}
      if (ls.size() < k) {return null;}
      if (t < 0) {return null;}
      if (k < 1) {return null;}   

      if (k == 1){

        Integer target = null;
        for(int i : ls){if ( i <= t){target = 0;}}
        for(int i : ls){
          if (i > t) {continue;}
          if (i > target) {target = i;}
        }
      return target;
      }
      

       // int n = 0; // initiate wor cicle WHILE
        Integer tempSum = null;
        Integer bestSum = 0;
        
        List<Integer> shortArray = new ArrayList<Integer>();
          for(int n = 0; n <= ls.size() - k; n++){
            if ( ls.get(n) > t) {continue;}

            shortArray = ls.subList(n+1, ls.size());
            //System.out.println("Short array:" +shortArray );
            tempSum = ls.get(n);
            Integer nextSum = chooseBestSum(t-tempSum, k-1, shortArray);
            if (nextSum == null){continue;}
            tempSum += nextSum;
            //if (tempSum > t) {continue;}
                
            if (tempSum > bestSum){bestSum = tempSum; }
          //System.out.println("Best sum: "+bestSum);
           //System.out.println("Out recursion:"+ t+":"+k+":"+ls.toString());
          }
          
          System.out.println("Best sum: "+bestSum);
          if (bestSum == 0) {return null;}
          return bestSum; 
        
          //System.out.println( t +":"+k+":"+ls.toString());
          //System.out.println(maxAllowedInt);
    }
    
}
