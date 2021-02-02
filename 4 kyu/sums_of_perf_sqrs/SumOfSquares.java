public class SumOfSquares {
    private static int[] powers = new int[0];
    public static int nSquaresFor(int n) {
      if(powers.length < 1){ initPowers();}
      int pos = (int)Math.sqrt(n);
      int min = 1000000000;
      int tmp= 0;
      while(pos > 0){
        tmp = calc(n - powers[pos]);
        if(min > tmp){ min = tmp;} 
        pos--;
      }
      
      return min+1;
    }
    
    private static int calc(int num){
      if (num < 0){return 100000000;}
      if (num == 0) {return  0;}
      
      int startPos = 0;
      int out = 0;
      //calc start position in powers[]
      startPos = (int)Math.sqrt(num) + 1;
      while(num - powers[startPos] < 0){
        startPos-- ;
      }
      out = 1 + calc(num - powers[startPos]);
      
    return out;
    }
    
    private static void initPowers(){
      powers = new int[31625];
      powers[0] = 0;
      int num = 1;
      int add = 3;
      for(int i = 1; i < 31625; i++){
        powers[i] = num;
        num += add;
        add += 2;
      }
    }
}