package com.example.utils;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String GetDateFormatString(String format, Date date) throws NullPointerException, IllegalArgumentException{
        return new SimpleDateFormat(format).format(date);
    }

    public static Date getCurrentYearDate(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Year.now().getValue());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
