import java.util.*;

public class TopWords {
    
    public static List<String> top3(String s) {
        System.out.println();
        System.out.println("----------------");
        System.out.println(s);
        System.out.println();
        Map<String, Integer> words = new HashMap<String, Integer>();
        String myStr = s.toLowerCase();
        
        myStr = myStr.replaceAll("[^a-z\\'\\s]"," ");
        myStr.replaceAll("  ", " ");
        System.out.println(myStr);
        System.out.println();
        String[] arr = myStr.split(" ");
        for(String sss : arr){
          if (sss.length() == 0 || sss.substring(0,1).equals("'")){ continue;}
          Integer freq = words.get(sss);
          if (freq == null) { freq = 0;}
          words.put(sss, freq+1);
        }
        System.out.println(words);
        return getTop(words);
    }
    
    public static ArrayList<String> getTop(Map<String, Integer> w){
      if (w.size() == 0) {return new ArrayList<String>();}
      String first = "";
      String second = "";
      String third = "";
      int max1,max2,max3 ;
      max1 = 0; max2 = 0; max3 = 0;
      for(Map.Entry<String, Integer> en : w.entrySet()){
        String word = en.getKey();
        Integer freq = en.getValue();
        //System.out.println(freq);
        if (freq > max1){
          max3 = max2;
          max2 = max1;
          max1 = freq;
          third = second;
          second = first;
          first = word;
        } else if (freq > max2){
          max3 = max2;
          max2 = freq;
          third = second;
          second = word;
        } else if (freq > max3){
          max3 = freq;
          third = word;
        }
        
        //System.out.format("[%d|%d|%d]\n",max1,max2,max3);
      }
      
      ArrayList<String> out = new ArrayList<String>();
      if (first.length() > 0){out.add(first);}
      if (second.length() > 0){out.add(second);}
      if (third.length() > 0){out.add(third);}
      
      return out;
    }
}
