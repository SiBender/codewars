class Solution {
    public static String rangeExtraction(int[] arr) {
      String out = "";
      //string += arr[0];
      int count = 1;
      for(int i = 0; i < arr.length - 1; i++){
        if(arr[i] == arr[i+1] - 1){
          count++;
        } else {
          switch (count){
            case 1: 
              out += "," + arr[i]; 
              break;
            case 2:
              out += "," + arr[i-1] + "," + arr[i];
              count = 1;
              break;
            default:
              out += "," + arr[i-count+1] + "-" + arr[i];
              count = 1;
              break;
          }
        }
      }
      
      switch (count){
              case 1: 
              out += "," + arr[arr.length - 1]; 
              break;
            case 2:
              out += "," + arr[arr.length - 1 - 1] + "," + arr[arr.length - 1];
              count = 1;
              break;
            default:
              out += "," + arr[arr.length - 1 -count+1] + "-" + arr[arr.length - 1];
              count = 1;
              break;
      } 
      return out.substring(1);
    }
}
