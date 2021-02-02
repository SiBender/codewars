import java.util.*;

public class KPrimes {
    public static ArrayList<Long> primes = new ArrayList<Long>();
    public static Primes myPrimes = new Primes();
    
    public static long[] countKprimes(int k, long start, long end) {
       
       //System.out.println("task:"+k+":"+start+":"+end);
       ArrayList<Long> kPrimes = new ArrayList<Long>();
       
       int kCount = 0 ;
       long num = 0;
       long upperLimDivider = 0;
       
       for (long i = start; i <= end; i++){
         int primePointer = 0;
         kCount = 0;
         num = i;
         //upperLimDivider = i;
           while (num > 0){
             long divider = myPrimes.primes[primePointer];
             if (divider > end) {break;}
             if (divider > num){break;}
             if (num % divider == 0) {
               kCount++;
               if (kCount > k){break;}
               num /= divider;
             } else {
               //upperLimDivider = i/myPrimes.primes[primePointer];
               primePointer++;               
             }
           }
         if (kCount == k) {kPrimes.add(i);}
       }
       int len = kPrimes.size();
       long[] out = new long[len];
       for(int x = 0; x < len; x++){
         out[x]=kPrimes.get(x);
       }
       return out;
    }
   
   
   public static int puzzle(int s) {
        long[] kOneArr = countKprimes(1, 0, s);
        long[] kThreeArr = countKprimes(3, 0, s);
        long[] kSevenArr = countKprimes(7, 0, s);


        
        //if (kOne.size() == 0 | kThree.size() == 0 | kSeven.size() == 0){return 0;}
        
        int count =0;
        
        for(long x : kOneArr){
          for(long y : kThreeArr){
            for(long z : kSevenArr){
              if (x + y + z == s){ count++; 
              //System.out.println("\nfound:"+x+ "+"+y+ "+"+z);
              }
            }
          }
        }
       // System.out.println("\nSolution:"+count);
        return count;// your code
    }
}

class Primes{
  public static long[] primes = new long[726517];
  public Primes(){
      boolean[] resheto = new boolean[11000001];
      resheto[0] = true;
      resheto[1] = true;
      int pointer = 2;
      while(pointer*pointer <= 11000000){
        if (resheto[pointer] == false){
          int mult = 2;
          int delPointer = pointer;
          while(delPointer*mult < 11000000){
            resheto[delPointer*mult] = true;
            mult++;
          }
        }
        pointer++;
      }
      int j = 0;
      for(int isPrime =0 ; isPrime < 11000000; isPrime++){
        if(resheto[isPrime] == false){
          primes[j]=(long)isPrime; 
          j++;
        }
      }
      //System.out.println("Num of primes:"+primes.length);
  }
}
