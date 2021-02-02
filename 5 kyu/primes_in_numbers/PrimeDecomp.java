import java.util.*;


public class PrimeDecomp {

      public static String factorsToStr(ArrayList<Integer> arr){
      if (arr.size() == 1) {return "(" + arr.get(0)+ ")";}
      int counter = 1;
      String outStr = "";
      for (int a = 0 ; a < arr.size() - 1; a++){
        if (arr.get(a) == arr.get(a+1)){
          counter++;
         // System.out.print(arr.get(a) +" ? "+ arr.get(a+1)+" ? ");
        } else {
          outStr += "("+arr.get(a);
          outStr += (counter > 1) ? "**" + counter : "";
          outStr += ")";
          counter=1;
        } 
        //System.out.println(arr.get(a) +" : "+ counter);
      }
      //System.out.println(counter);
      if (counter > 1) {outStr += "(" + arr.get(arr.size() -1) + "**" +counter + ")"; return outStr;}
      if (arr.get(arr.size() -1) != arr.get(arr.size() -2)) {
        outStr += "(" + arr.get(arr.size() -1) + ")";
      }
      return outStr;
    }
   
   
    public static String factors(int n) {
      ArrayList<Integer> factorsArr = new ArrayList<Integer>();    
        int divider = 2;
        while ( n > 1) {
          if ( n % divider == 0) {
            factorsArr.add(divider);
            n = n / divider;
          } else {
            divider++;
          }
        }
  //  for (int f : factorsArr){
  //   System.out.println(f);
  //  }
    return factorsToStr(factorsArr);
    }
       
}
