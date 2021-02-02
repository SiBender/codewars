// If no valid solution exists return null
import java.util.*;

public class Decompose {
  public static List<Long> decision;// 
  public static boolean decIsFound;//
  
  public String decompose(long n) {
    decIsFound = false;
    decision = new ArrayList<Long>(); // prepare clear state of object
    recDecompose(n*n, n-1);
    System.out.println("Last value" + decision);
    
    if (decIsFound == false) {return null;}
    
    String out = "";
    for (int j = decision.size() - 1; j >= 0; j-- ){
      out += " " + decision.get(j);
    }
    
    return out.substring(1);
  }
  
  public static void recDecompose(long rem, long top){
    if (rem == 0){
      decIsFound = true;
      return;
    }
   
    long i = top;
    while(rem > 0 && decIsFound == false && i > 0){
      decision.add(i);
      long newRem = rem - i*i;
      if (newRem >= 0){
        recDecompose(newRem, i-1);
      }
      
      if (decIsFound == true) { break; }
      
      decision.remove(decision.size() - 1);
      i--;
    }

    return;
  }
}
