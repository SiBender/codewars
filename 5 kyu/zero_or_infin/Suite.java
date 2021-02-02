public class Suite {
  public static double going(int n) {
    double sum = 1;
    double divider = 1;
    while(n >1){
      divider *= n;
      sum += 1/divider;
      n--;
    }
    sum = Math.floor(sum*1000000)/1000000;
    return sum;
  }
}
