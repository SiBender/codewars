import java.util.*;
    
class Bud {
//------------ +++++ factorize  +++++++ ----------------  
  public static ArrayList<Long> factorize(Long n){
     ArrayList<Long> arr = new ArrayList<Long>();
     if (n == 2){
        arr.add(2L); 
        return arr;
      }      
        double lim = Math.sqrt(n);
        for(long divider = 2 ; divider < lim; divider ++){
          if (n % divider == 0) {
            arr.add(divider);
            }
        }
        
        int count = arr.size();
        for(int i = count - 1; i >=0; i--){
          arr.add( n / arr.get(i) );
        }
      return arr;
    }
    
//------------ +++++ sumOfFactors  +++++++ ----------------  
  public static Long sumOfFactors(Long num){ // kata uses sum including 1, but we can just throw 1
      // so task transformates to sum(m) = n & sum(n) = m
      ArrayList<Long> arrOfDividers = factorize(num); 
      Long sum = 0L;
      for(Long f : arrOfDividers){ sum += f; }
    return sum;
  }

// ------------+++++  Buddy ++++-----------------
    public static String buddy(long start, long limit) {
       Long sum1 = 0L;
       long sum2 = 0L;
       
       for(Long i = start; i <=limit; i++){
           if (i == 2) {continue;}
          sum1 = sumOfFactors(i);
          if ( i > sum1 || sum1 < start){ continue; } // ??? sum1 > limit
          sum2 = sumOfFactors(sum1);
          if ( sum2  == i ){
            return "(" + i + " "+ sum1 + ")";
          }
       }
    return "Nothing";
    }
}
