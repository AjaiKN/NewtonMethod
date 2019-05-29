package newtonmethod;

import java.util.function.Function;

public class Derivative {
  public static final double SMALL_NUM = 1e-6;
  
  /**
   * Estimates the derivative f'(x) of f(x)
   * @param f the function f(x)
   * @return an estimate of f'(x) ~ (f(x+h)-f(x))/h, where h is the very small positive double SMALL_NUM
   */
  public static Function<Double, Double> derivativeEstimate(Function<Double, Double> f) {
    return x -> (f.apply(x + SMALL_NUM) - f.apply(x)) / SMALL_NUM;
  }
  
  public static void main(String[] args) {
    Function<Double, Double> derivativeOfXCubed = derivativeEstimate(x -> x * x * x);
    System.out.println("Derivative of x^3 at x=3: " + derivativeOfXCubed.apply(4.0));
  }
}
