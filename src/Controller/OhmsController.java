package Controller;

import Utils.DecimalUtils;

/**
 * Created by MCurtner on 3/28/2017.
 */

public class OhmsController {

    private int roundingDigits = 2;

    private static final int milli = 1000;
    private static final Double kilo = 0.001;
    private static final Double mega = 0.000001;

    private boolean isMilliAmp = false;
    private boolean isKiloOhms = false;
    private boolean isMegaOhms = false;

    // Setters
    public void setRoundingDigits(int roundingDigits) {
        this.roundingDigits = roundingDigits;
    }
    public void setMilliAmp(boolean milliAmp) {isMilliAmp = milliAmp;}
    private void isKiloOhms(boolean isKiloOhms) {this.isKiloOhms = isKiloOhms;}
    private void isMegaOhms(boolean isMegaOhms) {this.isMegaOhms = isMegaOhms;}

    public void toogleOhms(boolean useKilo, boolean useMega) {
        if (useKilo == true) {
            isKiloOhms(true);
            isMegaOhms(false);
        }
        if (useMega == true) {
            isKiloOhms(false);
            isMegaOhms(true);
        }
        if (useKilo == false && useMega == false) {
            isKiloOhms(false);
            isMegaOhms(false);
        }
    }

    //
    // ---------------------------------Logic--------------------------------------
    //
    // Ohms
    public Double calculateOhmsFromVoltsAndAmps(Double volts, Double amps) {
        if (isKiloOhms) {
            return DecimalUtils.round((volts / amps), roundingDigits) * kilo;
        }
        else if (isMegaOhms) {
            return DecimalUtils.round((volts / amps), roundingDigits) * mega;
        }
        else {
            return DecimalUtils.round((volts / amps), roundingDigits);
        }
    }

    public Double calculateOhmsFromVoltsAndWatts(Double volts, Double watts) {
        if (isKiloOhms) {
            return DecimalUtils.round(((volts * volts) / watts), roundingDigits) * kilo;
        }
        else if (isMegaOhms) {
            return DecimalUtils.round(((volts * volts) / watts), roundingDigits) * mega;
        }
        else {
            return DecimalUtils.round(((volts * volts) / watts), roundingDigits);
        }
    }

    public Double calculateOhmsFromWattsAndAmps(Double watts, Double amps) {
        if (isKiloOhms) {
            return DecimalUtils.round((watts / (amps * amps)), roundingDigits) * kilo;
        }
        else if (isMegaOhms) {
            return DecimalUtils.round((watts / (amps * amps)), roundingDigits) * mega;
        }
        else {
            return DecimalUtils.round((watts / (amps * amps)), roundingDigits);
        }
    }

    // Volts
    public Double calculateVoltsFromAmpsAndOhms(Double amps, Double ohms) {
        return DecimalUtils.round((amps * ohms), roundingDigits);
    }

    public Double calculateVoltsFromWattsAndAmps(Double watts, Double amps) {
        return DecimalUtils.round((watts / amps), roundingDigits);
    }

    public Double calculateVoltsFromWattsAndOhms(Double watts, Double ohms) {
        return DecimalUtils.round((Math.sqrt((watts * ohms))), roundingDigits);
    }

    //Amps
    public Double calculateAmpsFromVoltsAndOhms(Double volts, Double ohms) {
        if (isMilliAmp == true) {
            return DecimalUtils.round((volts / ohms), roundingDigits) * milli;
        } else {
            return DecimalUtils.round((volts / ohms), roundingDigits);
        }
    }

    public Double calculateAmpsFromWattsAndVolts(Double watts, Double volts) {
        if (isMilliAmp == true) {
            return DecimalUtils.round((watts / volts), roundingDigits) * milli;
        } else {
            return DecimalUtils.round((watts / volts), roundingDigits);
        }
    }

    public Double calculateAmpsFromWattsAndOhms(Double watts, Double ohms) {
        if (isMilliAmp == true) {
            return DecimalUtils.round((Math.sqrt((watts / ohms))), roundingDigits) * milli;
        } else {
            return DecimalUtils.round((Math.sqrt((watts / ohms))), roundingDigits);
        }
    }

    // Watts
    public Double calculateWattsFromVoltsAndAmps(Double volts, Double amps) {
        return DecimalUtils.round((volts * amps), roundingDigits);
    }

    public Double calculateWattsFromAmpsAndOhms(Double amps, Double ohms) {
        return DecimalUtils.round(((amps * amps) * ohms), roundingDigits);
    }

    public Double calculateWattsFromVoltsAndOhms(Double volts, Double ohms) {
        return DecimalUtils.round(((volts * volts) / ohms), roundingDigits);
    }
}
