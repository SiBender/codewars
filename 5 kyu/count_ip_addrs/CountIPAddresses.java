public class CountIPAddresses {

  public static long ipsBetween(String start, String end) {
    int[] startAddr = parseAddr(start);
    int[] endAddr = parseAddr(end);
    
    int result = 0;
    for(int i = 3, power = 1; i >= 0; i--) {
      result += (endAddr[i] - startAddr[i]) * power;
      power *= 256;
    }
    
    return result;
  }
  
  private static int[] parseAddr(String addr) {
    int[] output = new int[4];
    int pointer = 0;
    for(String s : addr.split("\\.")) {
      output[pointer] = Integer.parseInt(s);
      pointer++;
    }
    return output;
  }
}
