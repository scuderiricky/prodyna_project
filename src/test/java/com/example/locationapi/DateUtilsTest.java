package com.example.locationapi;

import com.example.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class DateUtilsTest {

    @Test
    void testWrongDateFormat() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->DateUtils.GetDateFormatString("wrong format",new Date()));
    }

    @Test
    void testNullableDateFormat() {
        Assertions.assertThrows(NullPointerException.class, ()->DateUtils.GetDateFormatString(null,new Date()));
    }

    @Test
    void testRightDateFormat() {
        Assertions.assertDoesNotThrow(()->DateUtils.GetDateFormatString("yyyy-mm-dd",new Date()));
    }

    @Test
    void testRightDate() {
      String date = DateUtils.GetDateFormatString("yyyy-MM-dd",new Date(121, Calendar.FEBRUARY,1));
        Assertions.assertEquals("2021-02-01", date);
    }
}
