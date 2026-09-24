package de.mide.datumsdifferenz;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;




/**
 * App zur Demonstration Event-Handling für das UI-Element "DatePicker".
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity {

    /**
     * Lifecycle-Methode, lädt Layout-Datei.
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }


    /**
     * Berechnet Anzahl Tage zwischen heute und dem als Argument übergebenen Datum.
     *
     * @param jahr Jahreszahl, z.B. 2021
     *
     * @param monat 1-basierter Monat (1=Januar, 12=Dezember)
     *
     * @param tagImMonat Tag im Monat, 1 bis 31 (je nach Anzahl Tage in {@code monat})
     *
     * @return Anzahl Tage zwischen heutigem Datum und Datum, das durch die Argumente
     *         beschrieben wird. Zahl ist negativ wenn das Datum in der Vergangenheit
     *         liegt.
     */
    private int berechneAnzahlTage( int jahr, int monat, int tagImMonat ) {

        Calendar heute = Calendar.getInstance();

        Calendar datum = Calendar.getInstance();
        datum.set( Calendar.YEAR, jahr               );
        datum.set( Calendar.MONTH, monat - 1         );
        datum.set( Calendar.DAY_OF_MONTH, tagImMonat );

        // Uhrzeit bei beiden Datumswerten auf Mitternacht setzen.
        heute.set( Calendar.HOUR_OF_DAY, 0 );
        heute.set( Calendar.MINUTE     , 0 );
        heute.set( Calendar.SECOND     , 0 );
        heute.set( Calendar.MILLISECOND, 0 );

        datum.set( Calendar.HOUR_OF_DAY, 0 );
        datum.set( Calendar.MINUTE     , 0 );
        datum.set( Calendar.SECOND     , 0 );
        datum.set( Calendar.MILLISECOND, 0 );

        long differenzMillis =
                datum.getTimeInMillis() - heute.getTimeInMillis();

        return (int) (differenzMillis / (24L * 60L * 60L * 1000L));
    }

}
