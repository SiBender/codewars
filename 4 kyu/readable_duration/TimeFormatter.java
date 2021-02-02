public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
       String[] intervals = new String[]{" year"," day"," hour"," minute"," second"};
       int[] div = new int[]{31536000, 86400, 3600, 60,1};
       
       if(seconds == 0){return "now";}
       
       String out = "";
       
       for(int i = 0; i < 5; i++){
         if(out.length() > 1) { out += seconds % div[i] == 0 ? " and " : ", "; }
         if(seconds / div[i] > 0){
           out += (seconds/div[i]) + intervals[i];
           out += seconds / div[i] > 1 ? "s" : "";
           seconds %= div[i];
         }
         if(seconds == 0){return out;}
       }

      return out;
    }
}
