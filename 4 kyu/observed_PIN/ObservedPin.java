import java.util.*;


public class ObservedPin {  
      public static  Map<String, String[]> numbersMap = new HashMap<String, String[]>() ;
      

    public static List<String> getPINs(String observed) {
      //testing methos does'nt allow to use Constructor of object to initialise Map, so i have to do THIS...
      numbersMap.put("0",new String[]{"0", "8"});
      numbersMap.put("1",new String[]{"1", "2", "4"});
      numbersMap.put("2",new String[]{"1", "2", "3", "5"});
      numbersMap.put("3",new String[]{"2", "3", "6"});
      numbersMap.put("4",new String[]{"1", "4", "5", "7"});
      numbersMap.put("5",new String[]{"2", "4", "5", "6", "8"});
      numbersMap.put("6",new String[]{"3", "5", "6", "9"});
      numbersMap.put("7",new String[]{"4", "7", "8"});
      numbersMap.put("8",new String[]{"5", "7", "8", "9", "0"});
      numbersMap.put("9",new String[]{"6", "8", "9"});
      List<String> empty = new ArrayList<String>();
      return generate(empty, observed);
    } 
    
    
  public static List<String> generate(List<String> prefixArr, String lastNums){
    
    if (lastNums.length() == 0){
      return prefixArr;
    }
    
    int prefLen = prefixArr.size();
    
    String nextNum = lastNums.substring(0,1);
    String[] nextPosible = numbersMap.get(nextNum);
    
    if (prefLen == 0) {
      return generate(Arrays.asList(nextPosible), lastNums.substring(1)); 
    }
 
    List<String> newPrefixArr = new ArrayList<String>();
    
    for(String prefix : prefixArr){
      for(String next : nextPosible){
        newPrefixArr.add(prefix + next);
      }
    }
    
    return generate(newPrefixArr, lastNums.substring(1));
  }
}
