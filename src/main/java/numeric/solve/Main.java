package numeric.solve;

import java.math.BigDecimal;

import static numeric.solve.util.BigDecimalHelper.*;

public class Main {
    public static void main(String[] args) {
        BigDecimal x = castToDecimal(1);
        BigDecimal y = castToDecimal(3);
        BigDecimal z = castToDecimal(0.0000000001);
        BigDecimal t = castToDecimal(0.5);
        System.out.println(z.intValue());
        System.out.println(x.stripTrailingZeros());
        System.out.println(y);
        System.out.println(divide(x,y));
        System.out.println(add(x,y));
        System.out.println(subtract(x,y));
        System.out.println(divide(x,z));
        System.out.println(multiply(x,y));
        BigDecimal p =  sqrt(add(x,x));
        System.out.println(Math.pow(2,0.5));
        System.out.println(p);
        System.out.println(p.stripTrailingZeros());
    }
}