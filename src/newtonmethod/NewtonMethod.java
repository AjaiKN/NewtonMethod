package newtonmethod;

import java.util.function.Function;
import static newtonmethod.Derivative.derivativeEstimate;

public class NewtonMethod {

  public static final double MAX_ERROR = 1e-10;

  /**
   * Uses Newton's Method to approximate x where f(x) = 0
   * @param f the function f(x) to be zeroed
   * @param fPrime the derivative f'(x) of the function f(x)
   * @param maxError the maximum absolute error in the estimate
   * @return an approximation of x where f(x) = 0
   */
  public static double newtonMethod(Function<Double, Double> f, Function<Double, Double> fPrime, double maxError) {
    double est = 1;
    while (Math.abs(f.apply(est)) >= maxError) {
      est -= f.apply(est) / fPrime.apply(est);
    }
    return est;
  }
  
  public static double newtonMethod(Function<Double, Double> f, Function<Double, Double> fPrime) {
    return newtonMethod(f, fPrime, MAX_ERROR);
  }

  public static double newtonMethod(Function<Double, Double> f, double maxError) {
    return newtonMethod(f, derivativeEstimate(f), maxError);
  }

  public static double newtonMethod(Function<Double, Double> f) {
    return newtonMethod(f, derivativeEstimate(f), MAX_ERROR);
  }
}
