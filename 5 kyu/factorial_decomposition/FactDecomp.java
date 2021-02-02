import java.util.*;

class FactDecomp {
    public static String arrToFact(ArrayList<Integer> arr){
      Map<Integer,Integer> m = new TreeMap<Integer,Integer>();
    
      for(int a : arr){
        Integer val = m.get(a);
        m.put(a, val == null ? 1 : val+1);
      }
      
      String outStr = "";
      
      for(Map.Entry<Integer,Integer> entry : m.entrySet()) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        
          outStr += " * ";
          outStr += key;
          outStr += value > 1 ? "^" + value : "";
        }
          return outStr.substring(3);
    }
    
    
    
    public static ArrayList<Integer> factorize(int n){
      //System.out.println("In recirsion:"+n);
      if (n == 2){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2));
        return arr;
      }
      
        ArrayList<Integer> dividerArr = new ArrayList<Integer>();
        int divider = 2;
        int m = n;
      while(m > 1){
        if ( m % divider == 0){
          dividerArr.add(divider);
          m = m / divider;
        } else {
          divider++;
        }
      }
      dividerArr.addAll(factorize(n - 1));
      return dividerArr;
    }
    
    public static String decomp(int n) {
        return arrToFact(factorize(n));
    }
} 
