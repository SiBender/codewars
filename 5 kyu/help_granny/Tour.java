import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Tour {
   
    
    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        double sum = 0;
        Map<String, Double> friendsWithPath = new HashMap<String, Double>(); // store friend + distance
        ArrayList<String> friendsToTravel  = new ArrayList<String>(); // friends without empty distances
        
        for(String friend : arrFriends){
          for(String[] fTown : ftwns){
            if(fTown[0].equals(friend) == true){
              friendsWithPath.put(friend, h.get(fTown[1]) );  
              friendsToTravel.add(friend);
              break; 
            }
          }
        }
        
        double a = 0;
        double c = 0;
        
        for(int i = 0; i < friendsToTravel.size() -1; i++){
          a = friendsWithPath.get(friendsToTravel.get(i));
          c = friendsWithPath.get(friendsToTravel.get(i+1));
          sum += Math.sqrt(c*c - a*a);
        }
        
        sum += friendsWithPath.get(friendsToTravel.get(0));
        sum += friendsWithPath.get(friendsToTravel.get(friendsToTravel.size() -1));
        return (int)sum;
    }
}
