package gr.aueb.softeng.team02.util;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

/*
 * Βοηθητική κλάση για τη λήψη της ημερομηνίας του συστήματος.
 * Η κλάση επιτρέπει να υποκατασταθεί η ημερομηνία του συστήματος με μία
 * προκαθορισμένη ημερομηνία. Η δυνατότητα αυτή
 * είναι ιδιαίτερη χρήσιμη για την εκτέλεση αυτόματων ελέγχων.
* */

public class SystemDate {

    /**
     * Απαγορεύουμε τη δημιουργία αντικείμενων.
     */
    protected SystemDate() { }

    private static LocalDate stub;


    /**
     * Θέτει μία συγκεκριμένη ημερομηνία ως την ημερομηνία του συστήματος.
     * Η ημερομηνία αυτή επιστρέφεται από την {@link SystemDate#now()}.
     * Εάν αντί για προκαθορισμένης ημερομηνίας τεθεί
     * {@code null} τότε επιστρέφεται
     * η πραγματική ημερομηνία του συστήματος
     * @param stubDate Η ημερομηνία η οποία θα επιστρέφεται
     * ως ημερομηνία του συστήματος ή {@code null} για
     * να επιστρέφει την πραγματική ημερομηνία
     */
    public static void setStub(LocalDate stubDate) {
        stub = stubDate;
    }

    /**
     * Απομακρύνει το στέλεχος.
     */
    public static void removeStub() {
        stub = null;
    }


    /**
     * Επιστρέφει την ημερομηνία του συστήματος ή μία
     * προκαθορισμένη ημερομηνία που έχει
     * τεθεί από την {@link SystemDate#setStub}.
     * @return Η ημερομηνία του συστήματος ή μία προκαθορισμένη ημερομηνία
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate now() {
        return stub == null ? LocalDate.now() : stub;
    }
}
