import java.util.*;

public class Dioph {
  public static List<Long> factorize(long num){
    List<Long> factors = new ArrayList<Long>();
    factors.add(1L);
    double lim = Math.sqrt(num);
    for(long divider = 2L ; divider <= lim ; divider++){
      if (num % divider == 0) {factors.add(divider);}
    }
    return factors;
  }
  
  public static String solEquaStr(long n) {
    List<Long> factors = new ArrayList<Long>();
    factors.addAll(factorize(n));
    List<Long> outArr = new ArrayList<Long>();
    long a = 0;
    long b = 0;
    
    for(int i = 0; i < factors.size(); i++ ){
      a=factors.get(i);
        b= n / a;
        if ((a+b) % 2 == 0 && (b-a) % 4 == 0){ 
          outArr.add((a+b)/2);
          outArr.add((b-a)/4);
          }

    }
    
    if (outArr.size() == 0){return "[]";}
    String out = "";
    out +="[";
    
    for(int k = 0 ; k < outArr.size()/2; k++){
     out += "[" + outArr.get(2*k) + ", " + outArr.get(2*k+1) + "], ";
    }
    
    out = out.substring(0, out.length() - 2)+"]";
    return out;
  }
  
}
