package numeric.solve;

import numeric.solve.model.ApproximationOfBesselEquation;
import numeric.solve.model.Function;
import numeric.solve.model.equations.BesselEquation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal nu = new BigDecimal("0");
        BigDecimal lambda = new BigDecimal("1");
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal step = new BigDecimal("0.01");
        int stepNumber = 2000;
        BesselEquation besselEquation = new BesselEquation(nu,lambda);
        besselEquation.calculateSolve(x0,step,stepNumber);
        besselEquation.getSolve().exportToFile("solve.txt");
        ApproximationOfBesselEquation approx = new ApproximationOfBesselEquation();
        approx.buildFunction(x0,step,stepNumber,nu);
        approx.exportToFile("approx.txt");
    }
}