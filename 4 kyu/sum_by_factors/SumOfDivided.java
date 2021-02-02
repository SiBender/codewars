import java.util.*;

public class SumOfDivided {
  private static Map<Integer, Integer> sums;
 
  public static String sumOfDivided(int[] l) {
    sums = new TreeMap<Integer, Integer>();
    for(int elem : l){
      addToMap(elem, factorise(elem));
    }
    
    return answerToString();
  }
  
  private static ArrayList<Integer> factorise(int in){
    ArrayList<Integer> out = new ArrayList<Integer>();
    int i = 2;
    int reminder = in > 0 ? in : in*(-1);
    while(i <= reminder){
      if (reminder % i == 0){
        if(out.contains(i) == false){
          out.add(i);
        }
        reminder /= i;
        continue;
      }
      i++;
    }
    if (out.size() == 0) {
      int tmp = in > 0 ? in : in*(-1);
      out.add(in);
    }
    return out;
  }
  
  private static void addToMap(int num, ArrayList<Integer> factors){
     for(Integer i : factors){
       Integer sum = sums.get(i);
       if (sum == null) { sum = 0;}
       sums.put(i, sum + num);
     }
  }
  
  private static String answerToString(){
    String out = "";
    for(Map.Entry<Integer, Integer> en : sums.entrySet()){
      Integer divider = en.getKey();
      Integer sumOfElems = en.getValue();
      out +="("+divider+" "+sumOfElems+")";
    }
    return out;
  }
}
