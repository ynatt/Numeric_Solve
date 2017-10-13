package numeric.solve.util;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

public class BigDecimalHelper {

    private static RoundingMode ROUND_MODE;
    private static int SCALE;
    static {
        try {
            FileReader fileReader = new FileReader("src/main/resources/config.properties");
            Properties config = new Properties();
            config.load(fileReader);
            ROUND_MODE = RoundingMode.valueOf(config.getProperty("rounding.mode"));
            SCALE = Integer.valueOf(config.getProperty("scale"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeRoundMode(RoundingMode roundingMode){
        ROUND_MODE=roundingMode;
    }

    public static BigDecimal castToDecimal(double number){
        return BigDecimal.valueOf(number).setScale(SCALE,ROUND_MODE);
    }

    public static BigDecimal add(BigDecimal a,BigDecimal b){
        return setScaleAndRound(a.add(b));
    }
    public static BigDecimal subtract(BigDecimal a, BigDecimal b){
        return setScaleAndRound(a.subtract(b));
    }

    public static BigDecimal multiply(BigDecimal a,BigDecimal b){
        return setScaleAndRound(a.multiply(b));
    }

    public static BigDecimal divide(BigDecimal a,BigDecimal b){
        return a.divide(b,ROUND_MODE);
    }

    public static BigDecimal pow(BigDecimal a,BigDecimal b){
        if(b.doubleValue()% 1 == 0){
            return setScaleAndRound(a.pow(b.intValue()));
        }else {
            return castToDecimal(Math.pow(a.doubleValue(),b.doubleValue()));
        }
    }

    public static BigDecimal sqrt(BigDecimal a){
        return pow(a,new BigDecimal("0.5"));
    }

    private static BigDecimal setScaleAndRound(BigDecimal decimal){
        return decimal.setScale(SCALE,ROUND_MODE);
    }
}
