public class Solve {
 
  public static double solve(double m) {
      double x = 0.0;
      x = 1.0 + 1.0/(2.0*m) - Math.sqrt(4.0*m+1.0)/(2.0*m);
      return x;
  }
}
