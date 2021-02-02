public class Fracts {
  public static String convertFrac(long[][] lst) {
   long common = 1;
   long tmp = common;
   long div = 2;
   long denom = 0;
   for(int i = 0; i< lst.length; i++){
     lst[i] = reduce(lst[i]);
     if(lst[i][1] % lst[i][0] == 0){}
     denom = lst[i][1];
     div = 2;
     tmp = common;
     while(denom > 1){
          if(denom % div == 0){
            denom /= div;
            if(tmp % div == 0 && tmp > 0){
              tmp /= div;
            } else {
              common *= div;
            }
          continue;
          }
          div++;
     }      
   }
   
   String out = "";
   for(long[] pare : lst){
     out += "("+(pare[0]*common/pare[1])+","+common+")";
   }
   
   return out;
  }
  
  private static long[] reduce(long[] arr){
    long tmp = arr[0];
    long divisor = 2;
    while(tmp > 1){
      if(tmp % divisor == 0){
        tmp /= divisor;
        if(arr[1] % divisor == 0){
          arr[0] /= divisor;
          arr[1] /= divisor; 
        }
        continue;
      }
      divisor++;
    }
  return arr;
  }

}
