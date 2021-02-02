//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32  - 32 bit
//0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  0  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1
//0 0 0 0 0 0 0 0 1 1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0  0  0  0  0  0  0  0
//0 0 0 0 1 1 1 1 1 1  1  1  0  0  0  0  0  0  0  0  1  1  1  1  1  1  1  1  0  0  0  0
//0 0 1 1 1 1 0 0 0 0  1  1  1  1  0  0  0  0  1  1  1  1  0  0  0  0  1  1  1  1  0  0
//0 1 1 0 0 1 1 0 0 1  1  0  0  1  1  0  0  1  1  0  0  1  1  0  0  1  1  0  0  1  1  0


public class MysteryFunction {
  private static long[] powers;
  private static int[] answers = new int[]{0,1,1,0};
  
  public static long mystery(long n) {
    createPowers(); 
    int len = Long.toBinaryString(n).length();
    long out = 0L;
    long flag = 0L;
    for(int i = 0; i < len; i++){
      flag = (n/powers[i]) % 4;
      if (answers[(int)flag] == 1){
         out += powers[i];
      }
    }

    return  out;
  }


//1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6       7 8 9 0   1 2 3 4    5 6 7 8   9 0 1 2  -  32 bit
//0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0       1 1 1 1   1 1 1 1    1 1 1 1   1 1 1 1
//0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1       1 1 1 1   1 1 1 1    0 0 0 0   0 0 0 0
//0 0 0 0 1 1 1 1 1 1 1 1 0 0 0 0       0 0 0 0   1 1 1 1    1 1 1 1   0 0 0 0
//0 0 1 1 1 1 0 0 0 0 1 1 1 1 0 0       0 0 1 1   1 1 0 0    0 0 1 1   1 1 0 0
//0 1 1 0 0 1 1 0 0 1 1 0 0 1 1 0       0 1 1 0   0 1 1 0    0 1 1 0   0 1 1 0
  public static long mysteryInv(long n) {
    createPowers();
    char[] bitsOfN = Long.toBinaryString(n).toCharArray();
    int len = bitsOfN.length;
    long out = 0L;
    
    String prev = "Left"; // one of [Left, Right] previouse position in table. Move from ut to down
    
    for(int i = 0; i<len; i++){
      if(prev.equals("Left") == true){
          if(bitsOfN[i] == '1'){ out += powers[len - i -1]; prev = "Right"; } 
          else { prev = "Left"; }
      } else {
          if(bitsOfN[i] == '0'){ out += powers[len - i - 1]; prev = "Right"; }
          else {prev = "Left";}
      }
    }

    return out;
  }

  public static String nameOfMystery() {

    return "gray code";
  }
  
  private static void createPowers(){
    powers = new long[64];
    long val = 1L;
    for(int i = 0; i < 64; i++){
      powers[i] = val;
      val *= 2;
    }
    return;
  }

}