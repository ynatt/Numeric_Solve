package numeric.solve.model;

import numeric.solve.util.BigDecimalHelper;

import java.math.BigDecimal;

import static numeric.solve.util.BigDecimalHelper.*;

public class ApproximationOfBesselEquation extends Function {
    public void buildFunction(BigDecimal x0,BigDecimal step,int stepNumber,BigDecimal nu){
        BigDecimal argument = x0;
        for(int i=0;i<=stepNumber;i++){
            super.addArgAndValue(argument, pow(argument,add(new BigDecimal("0.5"),nu)));
            argument = add(argument,step);
        }
    }
}
