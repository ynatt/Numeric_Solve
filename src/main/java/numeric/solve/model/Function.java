package numeric.solve.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Function {
    private String argumentName="x";
    private String valueName="y";
    private Map<BigDecimal,BigDecimal> argToValue = new LinkedHashMap<>();

    public Function(Map<BigDecimal,BigDecimal> argToValue){
        if(argToValue!=null){
            this.argToValue=argToValue;
        }
    }

    public void addArgAndValue(BigDecimal argument,BigDecimal value){
        if(argument!=null || value!=null){
            argToValue.put(argument,value);
        }else {
            throw new IllegalArgumentException("Argument or value of can't be null!");
        }
    }

    @Override
    public String toString() {
        return argToValue.toString();
    }
}
