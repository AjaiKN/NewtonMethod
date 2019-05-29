package newtonmethod;

import java.util.function.Function;

public class DefiniteIntegral {
  public static final int DEFAULT_N = 100000;
  
  public static void main(String[] args) {
    System.out.print("Integral from 3 to 5 of x^2: ");
    System.out.println(rightSum(x -> x * x, 3, 5));
  }
  
  /**
   * Estimates the definite integral from a to b of f
   * by using a right Riemann sum with n partitions
   * @param f the function to be integrated
   * @param a the left bound
   * @param b the right bound
   * @param n the number of partitions for the Riemann sum
   * @return an estimate of the definite integral
   */
  public static double rightSum(Function<Double, Double> f, double a, double b, int n) {
    double deltaX = (b - a) / n;
    double ret = 0;
    for (int i = 1; i <= n; i++) {
      double xi = a + deltaX * i;
      ret += f.apply(xi) * deltaX;
    }
    return ret;
  }
  
  public static double rightSum(Function<Double, Double> f, double a, double b) {
    return rightSum(f, a, b, DEFAULT_N);
  }
}
