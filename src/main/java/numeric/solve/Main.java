package numeric.solve;

import numeric.solve.model.equations.BesselEquation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BesselEquation besselEquation = new BesselEquation(BigDecimal.ONE,BigDecimal.ONE);
        besselEquation.calculateSolve(BigDecimal.ZERO,new BigDecimal("0.01"),2000);
        besselEquation.getSolve().exportToFile("solve.txt");
    }
}