package numeric.solve.model.equations;

import numeric.solve.model.Function;
import org.apache.commons.math3.special.BesselJ;

import java.math.BigDecimal;

import static numeric.solve.util.BigDecimalHelper.*;

public class BesselEquation {
    private String type = "-y''+(nu^2-1/4)*y/x^2=lambda*y";

    private final BigDecimal nu;

    private final BigDecimal lambda;

    private Function solve = new Function();

    public BesselEquation(){
        nu = BigDecimal.ZERO;
        lambda = BigDecimal.ONE;
    }

    public BesselEquation(BigDecimal nu,BigDecimal lambda){
        this.nu = nu;
        if(lambda.compareTo(BigDecimal.ZERO) < 0){
            this.lambda=lambda.negate();
        }else {
            this.lambda=lambda;
        }
    }

    public BigDecimal getNu() {
        return nu;
    }

    public BigDecimal getLambda() {
        return lambda;
    }

    public Function getSolve() {
        return solve;
    }

    public void calculateSolve(BigDecimal x0, BigDecimal step, int stepNumber){
        System.out.println("x0 ="+x0+" step ="+step+" stepNumber="+stepNumber);
        BigDecimal ro = sqrt(lambda);
        BigDecimal argument = x0;
        for(int i = 0;i<=stepNumber;i++){
            solve.addArgAndValue(argument,
                    multiply(pow(argument,add(new BigDecimal("0.5"),nu)),castToDecimal(BesselJ.value(nu.doubleValue(), multiply(ro,argument).doubleValue()))));
            argument=add(argument,step);
        }
    }
}
