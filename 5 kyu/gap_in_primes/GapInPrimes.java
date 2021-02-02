import java.util.Arrays;

class GapInPrimes {
    public static boolean isPrime(long num){
      if (num == 2){ return true;}
      if (num < 2 || num % 2 == 0){ return false;}
      long divisor = 3L;
      while(divisor*divisor <= num){
        if (num % divisor == 0){ return false;}
        divisor += 2;
      }
      return true;
    }    
    
    
    public static long[] gap(int g, long m, long n) {
        long start = m == 2 || m%2 == 1 ? m : m+1;
        long[] answer = new long[2];
        boolean rightGap = true;
        for (long i = start; i <= n; i+=2){
          if (isPrime(i) == true){ 
            if (i + g <= n && isPrime(i + g) == true){
              rightGap = true;
              for (long j = i+2; j < i+g; j += 2){
                if (isPrime(j) == true) { rightGap = false; break;}
              }
              if (rightGap == true){
                answer[0] = i;
                answer[1] = i + g;
                return answer;
              }
            }
          }
        }
        return null;
    }
}
