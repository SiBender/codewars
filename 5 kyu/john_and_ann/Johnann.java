import java.util.*;

public class Johnann {
    public static Map<Long, Long> John = new HashMap<Long, Long>();
    public static Map<Long, Long> Ann = new HashMap<Long, Long>();
    public static long jSumm = 0L;
    public static long aSumm = 1L;
    
    public static void generateMaps(long n){
    System.out.println("n:"+n);
      John.clear();
      Ann.clear();
      jSumm = 0L;
      aSumm = 1L;
      
      Ann.put(0L,1L);
      John.put(0L,0L);
      long i = 1L;
      long nextAnn;
      long nextJohn;
      long lastAnn = 1L;
      long lastJohn = 0L;
      while( i < n ){
        nextJohn = i - Ann.get(lastJohn);
        John.put(i, nextJohn);
        nextAnn = i - John.get(lastAnn);
        Ann.put(i, nextAnn);
        jSumm += nextJohn;
        aSumm += nextAnn;
        lastAnn = nextAnn;
        lastJohn = nextJohn;
        i++;
      }
    }
    
    public static List<Long> john(long n) {
        generateMaps(n);
        List<Long> johnList = new ArrayList<Long>();
        
        for(long i = 0; i < n ; i++){
          johnList.add(John.get(i));
        }
        return johnList;
    }
    
    public static List<Long> ann(long n) {
        generateMaps(n);
        List<Long> annList = new ArrayList<Long>();
        
        for(long i = 0; i < n; i++){
          annList.add(Ann.get(i));
        }

        return annList;
    }
    
    public static long sumJohn(long n) {
        generateMaps(n);
        return jSumm;
    }
    
    public static long sumAnn(long n) {
        generateMaps(n);
        return aSumm;
    }
}
