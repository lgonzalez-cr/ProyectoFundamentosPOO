package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Commons {
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd-HH-mm-ss-SSS";

    public static String now() {
        String date="";

        try {
            TimeUnit.MILLISECONDS.sleep(1);
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            date = sdf.format(cal.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return date;
    }
}
