class PrimeConsec {
    
    private static long[] kVal;
    public static int consecKprimes(int k, long[] arr) {
        kVal = new long[arr.length];
        for(int i = 0; i < arr.length ; i++){
          calcK(arr[i], i);
        }
        
        int count = 0;
        for(int j =0; j < kVal.length-1; j++){
          if((int)kVal[j] == k && kVal[j] == kVal[j+1]){count++;}
        }
        return count;
    }
    
    private static void calcK(long n, int i){
       int k = 0;
       long div = 2;
       while(n/div > 0){
         if(n % div == 0){
           k++;
           n /= div;
         } else {
           div++;
         }
       }
       if (k ==0){k=1;}
       kVal[i]=k;
    }
}
