package Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by MCurtner on 3/29/2017.
 */
class OhmsControllerTest {

    OhmsController cont;

    @BeforeEach
    void setUp() {
        cont = new OhmsController();
        cont.setRoundingDigits(3);
        cont.setMilliAmp(false);
        cont.toogleOhms(false, false);
    }

    @AfterEach
    void tearDown() {

    }

    // Resistance
    @Test
    void calculateOhmsFromVoltsAndAmps() {
        assertEquals(3.0, cont.calculateOhmsFromVoltsAndAmps(12.0, 4.0), 1.0 );

        cont.toogleOhms(true, false);
        assertEquals(0.003, cont.calculateOhmsFromVoltsAndAmps(12.0, 4.0), 0.0001 );

        cont.setRoundingDigits(6);
        cont.toogleOhms(false, true);
        assertEquals(0.0000305, cont.calculateOhmsFromVoltsAndAmps(124.0, 4.0), 0.000001 );
    }

    @Test
    void calculateOhmsFromVoltsAndWatts() {
        assertEquals(36.0, cont.calculateOhmsFromVoltsAndWatts(12.0, 4.0), 0.001 );
    }

    @Test
    void calculateOhmsFromWattsAndAmps() {
        assertEquals(16.0, cont.calculateOhmsFromWattsAndAmps(144.0, 3.0), 0.001 );
    }

    // Voltage
    @Test
    void calculateVoltsFromAmpsAndOhms() {
        assertEquals(432.0, cont.calculateVoltsFromAmpsAndOhms(144.0, 3.0), 0.001 );
    }

    @Test
    void calculateVoltsFromWattsAndAmps() {
        assertEquals(48.0, cont.calculateVoltsFromWattsAndAmps(144.0, 3.0), 0.001 );
    }

    @Test
    void calculateVoltsFromWattsAndOhms() {
        assertEquals(20.785, cont.calculateVoltsFromWattsAndOhms(144.0, 3.0), 0.001 );
    }

    // Amps
    @Test
    void calculateAmpsFromVoltsAndOhms() {
        assertEquals(48.0, cont.calculateAmpsFromVoltsAndOhms(144.0, 3.0), 0.001);

        cont.setMilliAmp(true);
        assertEquals(48000, cont.calculateAmpsFromVoltsAndOhms(144.0, 3.0), 0.001);
    }

    @Test
    void calculateAmpsFromWattsAndVolts() {
        assertEquals(48.0, cont.calculateAmpsFromWattsAndVolts(144.0, 3.0), 0.001 );

        cont.setMilliAmp(true);
        assertEquals(48000, cont.calculateAmpsFromWattsAndVolts(144.0, 3.0), 0.001);
    }

    @Test
    void calculateAmpsFromWattsAndOhms() {
       assertEquals(6.928, cont.calculateAmpsFromWattsAndOhms(144.0, 3.0), 0.001 );

       cont.setMilliAmp(true);
       assertEquals(6928.0, cont.calculateAmpsFromWattsAndOhms(144.0, 3.0), 0.001 );
    }

    // Watts
    @Test
    void calculateWattsFromVoltsAndAmps() {
        assertEquals(432.0, cont.calculateWattsFromVoltsAndAmps(144.0, 3.0), 0.001 );
    }

    @Test
    void calculateWattsFromAmpsAndOhms() {
        assertEquals(62208.0, cont.calculateWattsFromAmpsAndOhms(144.0, 3.0), 0.001 );
    }

    @Test
    void calculateWattsFromVoltsAndOhms() {
        assertEquals(6912.0, cont.calculateWattsFromVoltsAndOhms(144.0, 3.0), 0.001 );
    }
}