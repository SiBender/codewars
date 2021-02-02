import java.util.*;

public class WeightSort {
  private static Number[] nums;
  private static int count;
  
  public static String orderWeight(String strng) {
    if (strng.length() == 0) {return "";}
    
    count = 0;
    String[] tmp = strng.split(" ");
    ArrayList<String> arr1 = new ArrayList<String>(Arrays.asList(tmp));
    Collections.sort(arr1);
    System.out.println();
    
    nums = new Number[arr1.size()];
    for(int i = 0; i < arr1.size(); i++){
        put(arr1.get(i));
    }
    
    String out = "";
    for(Number n : nums){
      out += " " + n.value;
    }
  
    return out.substring(1);
  }
  
  private static void put(String in){
    Number num = new Number(in);
    if (count == 0){
      nums[0] = num;
      count++;
      return;
    }

    int point = count;
    while(point > 0 && num.weight < nums[point-1].weight){
      nums[point] = nums[point-1];
      point--;
    }
    nums[point] = num;
    
    if(point > 0 && num.weight == nums[point-1].weight){
      if(num.value.compareTo(nums[point-1].value) == -1){
        nums[point] = nums[point-1];
        nums[point-1] = num;
      } 
    }
    count++;
    return;
  }
}

class Number{
  public int weight;
  public String value;
 
  public Number(String n){
    value = n;
    int len = n.length(); ;
    while(len > 0){
      weight += Integer.parseInt(n.charAt(len-1)+"");
      len--;
    }
  }
  
  public String toString(){
    return "" + weight + "("+value+")";
  }
}
