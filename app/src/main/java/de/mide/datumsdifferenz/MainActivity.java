package de.mide.datumsdifferenz;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Date;


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
     * <br><br>
     *
     * Verwendet die Bibliothek "joda-time", siehe Dependency-Eintrag in Datei
     * {@code app/build.gradle}.
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

        final LocalDate heuteLocalDate   = new LocalDate( new Date() );
        final LocalDate anderesLocalDate = LocalDate.parse( jahr + "-" + monat + "-" + tagImMonat );

        // Klasse Days ist aus joda-time
        Days days = Days.daysBetween( heuteLocalDate, anderesLocalDate );

        return days.getDays();
    }

}
