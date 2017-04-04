package Utils;

import java.math.BigDecimal;

/**
 * Created by mcurtner on 4/3/2017.
 */
public class DecimalUtils {
    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
