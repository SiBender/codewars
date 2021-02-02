class Solution{
  //result of some research
    private static final long[] borders = {0l, 45l, 9045l, 1395495l, 189414495l, 23939649495l, 
                                     2893942449495l, 339393974949495l, 38939394344949495l};
  
    private static final long[] firstElementLength = {0l, 1l ,11l, 192l, 2893l, 38894l, 488895l, 
                                                5888896l, 68888897l, 788888898l};

   
    public static int solve(long n){
      int numLen = calcBaseNumberLength(n);
      long remainingLength = n - borders[numLen - 1];
      
      int stepNumber = calcStepNumber(numLen, remainingLength);
      remainingLength -= calcProgressionSum(firstElementLength[numLen], numLen, stepNumber - 1);
      
      
      for(int i = 1; i <= numLen; i++) {
        long countOfElementsByLength = 9 *  (long)Math.pow(10, i - 1);
        long totalLengthByGivenElementLength = countOfElementsByLength * i;
        if (remainingLength - totalLengthByGivenElementLength <= 0) {
          long count = (remainingLength - 1) / i;
          long fondNumber = (long)Math.pow(10, i -1) + count;
          long position = (remainingLength - 1 ) % i;
          return Integer.parseInt(String.valueOf(("" + fondNumber).charAt((int)position)));
        }
        remainingLength -= totalLengthByGivenElementLength;
      }
      
      return -1;
    }
  
  
  private static int calcBaseNumberLength(long n) {
    for (int i = 0; i < borders.length; i++) {
      if (borders[i] >= n) {return i;}
    }
    return 9;
  }
  
  
  private static int calcStepNumber(int numLen, long remainingLen) {
    long start = 1;
    long end = (long)(Math.pow(10, numLen)) - 1;
    long startElem = firstElementLength[numLen];
    while(start < end) {
      long middle = (start+end) / 2;
      if (calcProgressionSum(startElem, numLen, middle) >  remainingLen) {
        end = middle;
      } else {
        start = middle;
      }
      
      if (start == end - 1) {break;}
    }
    long result = (calcProgressionSum(startElem, numLen, start) < remainingLen) ? end : start;
    return (int)result;
  } 
  
  private static long calcProgressionSum(long firstElem, int step, long count) {
    return (2*firstElem + step*(count-1))*count/2;
  }
}