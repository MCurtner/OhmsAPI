package Controller;

import Utils.DecimalUtils;

/**
 * Created by MCurtner on 3/28/2017.
 */
public class OhmsController {

    private int roundingDigits = 2;

    public void setRoundingDigits(int roundingDigits) {
        this.roundingDigits = roundingDigits;
    }

    // Ohms
    public Double calculateOhmsFromVoltsAndAmps(Double volts, Double amps) {

        return DecimalUtils.round((volts / amps), roundingDigits) ;
    }

    public Double calculateOhmsFromVoltsAndWatts(Double volts, Double watts) {

        return DecimalUtils.round(((volts * volts) / watts), roundingDigits);
    }

    public Double calculateOhmsFromWattsAndAmps(Double watts, Double amps) {

        return DecimalUtils.round((watts / (amps * amps)), roundingDigits);
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
        return DecimalUtils.round((volts / ohms), roundingDigits);
    }

    public Double calculateAmpsFromWattsAndVolts(Double watts, Double volts) {
        return DecimalUtils.round((watts / volts), roundingDigits);
    }

    public Double calculateAmpsFromWattsAndOhms(Double watts, Double ohms) {
        return DecimalUtils.round((Math.sqrt((watts / ohms))), roundingDigits);
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
