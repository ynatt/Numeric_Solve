package numeric.solve.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Function {
    private String argumentName="x";
    private String valueName="y";
    private Map<BigDecimal,BigDecimal> argToValue = new LinkedHashMap<>();

    public Function(){

    }

    public Function(Map<BigDecimal,BigDecimal> argToValue){
        if(argToValue!=null){
            this.argToValue=argToValue;
        }
    }

    public Map<BigDecimal, BigDecimal> getFunction() {
        return argToValue;
    }

    public void addArgAndValue(BigDecimal argument, BigDecimal value){
        if(argument!=null || value!=null){
            argToValue.put(argument,value);
        }else {
            throw new IllegalArgumentException("Argument or value of can't be null!");
        }
    }

    public void exportToFile(String fileName){
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for(BigDecimal argument : argToValue.keySet() ){
                fileWriter.write(""+argument+" "+argToValue.get(argument)+"\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return argToValue.toString();
    }
}
