public class DirReduction {
   public static boolean isOpposite(String dir1, String dir2){
     
     switch (dir1) {
       case "NORTH": 
         if (dir2.equals("SOUTH")) { System.out.println("N-S"); return true;} break;
       case "SOUTH": 
         if (dir2.equals("NORTH")) { System.out.println("S-N"); return true;} break;
       case "EAST": 
         if (dir2.equals("WEST")) {System.out.println("E-W"); return true;} break;
       case "WEST": 
         if (dir2.equals("EAST")) {System.out.println("W-E"); return true;} break;
       }  
     return false;
   }
      
   public static String[] dirReduc(String[] arr) {
        if (arr.length == 0){
          return new String[]{};
        }
        
        int count = 0;
        for(int i = 0; i < arr.length -1 ; i++){
            System.out.println("----- i ="+i + " j="+(i+1));
            if (isOpposite(arr[i], arr[i+1])) {
              arr[i]="";
              arr[i+1]="";
              count +=2;
          }
        }
        if (count == 0) {return arr;}
        
        String[] bestRoute = new String[arr.length - count];
        int pointer = 0;
        for (String str : arr){
          if (str.equals("") == false) {
          bestRoute[pointer] = str;
          pointer++;
          }
        }
        return dirReduc(bestRoute);
    }
}
