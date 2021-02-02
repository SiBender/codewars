import java.util.*;
public class Kata{
  public static String Factorial(int n) {
    Number num = new Number();
    for(int i = 1; i <= n; i++){
      num.multiply(i);
    }
    return num.print();
  }
}

class Number{
  private static int[] digits;
  private static int endOfNum;
  
  public Number(){
    digits = new int[1000];
    for(int i = 0; i < 1000; i++){ digits[i] = 0;}
    digits[0] = 1;
    endOfNum = 0;
  }
  
  public void multiply(int n){
    int position = 0;
    int reminder = 0;
    int tmp;
    for(int i = 0; i <= endOfNum; i++){
      tmp = digits[i]*n;
      digits[i] = (tmp + reminder) % 10;
      reminder = (tmp + reminder) / 10;
    }
    
    while(reminder > 0){
      digits[++endOfNum] = reminder % 10;
      reminder /= 10;
    }
  }
  
  public static String print(){
    String out = "";
    for (int i = endOfNum; i >=0; i--){
      out += digits[i];
    }
    return out;
  }
}