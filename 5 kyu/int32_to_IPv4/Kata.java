public class Kata {
  public static String longToIP(long ip) {
    return ""+(ip >>> 24)+ "."+(ip >>> 16)%256+"."+(ip >>> 8)%256+"."+(ip % 256);
  }
}