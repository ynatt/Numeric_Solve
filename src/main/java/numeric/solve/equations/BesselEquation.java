package numeric.solve.equations;

import java.math.BigDecimal;

public class BesselEquation {
    private String type = "-y''+(nu^2-1/4)*y/x^2=lambda*y";

    private BigDecimal nu;

    private BigDecimal lambda;

    public BesselEquation(){
        nu = BigDecimal.ZERO;
        lambda = BigDecimal.ONE;
    }

    public BesselEquation(BigDecimal nu,BigDecimal lambda){
        this.nu = nu;
        this.lambda=lambda;
    }

    public void setNu(BigDecimal nu) {
        this.nu = nu;
    }

    public BigDecimal getNu() {
        return nu;
    }

    public BigDecimal getLambda() {
        return lambda;
    }

    public void setLambda(BigDecimal lambda) {
        this.lambda = lambda;
    }
}
