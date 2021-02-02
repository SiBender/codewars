import java.util.*;
public class Max {
  public static int sequence(int[] arr) {
    if (arr.length==0) { return 0;}
    int maxSum = 0;
    for(int len = 1; len<=arr.length; len++){
      for(int i=0; i <= arr.length - len; i++){
      int[] subArray = Arrays.copyOfRange(arr, i, i+len);
        int sum = 0;
        for(int s : subArray){
          sum += s;
        }
        if (sum > maxSum){ maxSum = sum; }
      }
    }
    return maxSum;
  }
}
