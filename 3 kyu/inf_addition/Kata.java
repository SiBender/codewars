public class Kata {
  private static int firstStartPos;
  private static int secondStartPos;
  
  public static int findDigit(int n) {
    firstStartPos = 0;
    secondStartPos = 0;
    String upNum = generateFirst(n).substring(n - firstStartPos);
    String downNum = generateSecond(n).substring(n - secondStartPos);
    
    int minLen = upNum.length() < downNum.length() ? upNum.length() : downNum.length();
    
    int addOne = 0;
    int tmpSum = 0;
    for(int i = minLen - 1; i >=0; i--){
      tmpSum = ((upNum.charAt(i) - '0') + (downNum.charAt(i) - '0')) + addOne;
      addOne = tmpSum / 10;
    }   
    return tmpSum % 10;
  }
  
  private static String generateFirst(int x){
    int startPos = 0 ;
    int lenNext = 1;
    long leftNum = 1;
    long rightNum = 2;
    long additionalNum = 3;
    String out = "";
    
    long m = (long)x;
    
    long len = 1L;
    long powOfTen = 1L;
    long num = 1L;
    while(m - 9*len*powOfTen > 0){
      m = m - 9*len*powOfTen;
      startPos += 9*len*powOfTen;
      num += 9*powOfTen;
      len++;
      powOfTen *=10;

    }
    startPos += m- m % len;
    leftNum = num + m/len;
    
    rightNum = leftNum+1;
    additionalNum = leftNum+2;
    out = "" + leftNum + (leftNum+1) + (leftNum+2);
    firstStartPos = startPos;
    
    return out; 
  }
  
  private static String generateSecond(int x){
    long[] len = new long[]{0L, 3L, 6L, 22L, 68L, 217L, 683L, 2163L, 6837L, 21623L, 
                            68377L, 216228L, 683772L, 2162278L, 6837722L, 21622777L, 
                            68377223L, 216227767L, 683772233L, 2037000499L, 2037000499L};
    int startPos = 0 ;
    int lenNext = 1;
    long leftNum = 0L;
    long rightNum = 4L;
    long additionalNum = 9L;
    String out = "";
    
    long m = (long)x;
    long n =1L;
    int pos = 1;
    long number = 0L; 
    
    while(m > len[pos]*pos){
      m -= len[pos]*pos;
      startPos += len[pos]*pos;
      number += len[pos];
      pos++;
    }
    startPos += m - m % pos;
    number += m / pos;
        
    leftNum = (number+1)*(number+1);
    rightNum = (number+2)*(number+2);
    additionalNum = (number+3)*(number+3);

    out = "" + leftNum + rightNum + additionalNum;
    secondStartPos = startPos;
    
    return out; 
  }
}