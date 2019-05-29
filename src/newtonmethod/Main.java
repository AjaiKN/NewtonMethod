package newtonmethod;

import static newtonmethod.Derivative.derivativeEstimate;
import static newtonmethod.NewtonMethod.newtonMethod;

public class Main {
  public static void main(String[] args) {
    // estimate cube root of 2 with derivative given manually
    // f(x) = n^3 - 2
    // f'(x) = 3n^2
    double cubeRoot2 = newtonMethod(n -> n * n * n - 2, n -> 3 * n * n);
    System.out.println("cube root of 2: " + cubeRoot2);

    // sqrt(2) with derivative approximated by derivativeEstimate(f)
    double sqrt2 = newtonMethod(n -> n * n - 2);
    System.out.println("square root of 2: " + sqrt2);

    // phi (golden ratio)
    // phi-1 = 1/phi
    double phi = newtonMethod(x -> (x-1 - 1/x));
    System.out.println("phi: " + phi);

    /*
     estimate e
     (e^x)' = e^x

     e is a number n where, for any number a,
     d (n^x)|    = n^a
     --     |
     dx     |n=a
    
     This equation is true for both 0 and e. If a > 1, Newton's Method finds 0 rather than e.
     */
    double a = .8;
    double e = newtonMethod(n -> derivativeEstimate(x -> Math.pow(n, x)).apply(a) - Math.pow(n, a), 1e-11);
    System.out.println("e: " + e);

    // omega constant
    // xe^x = 1
    double omega = newtonMethod(x -> x * Math.pow(e, x) - 1);
    System.out.println("omega: " + omega);

    // pi
    // cos(pi) = -1
    double pi = newtonMethod(x -> 1 + Math.cos(x), 1e-20);
    System.out.println("pi: " + pi);
  }
}