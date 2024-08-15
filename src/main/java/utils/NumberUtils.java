package utils;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class NumberUtils {

    public static final int TWO_DIGITS_BOUND_VALUE = 99;

    public static int generateTwoDigitsRandom() {
        return new SecureRandom().nextInt(TWO_DIGITS_BOUND_VALUE);
    }

    public static String generateUniqueTextBasedOnDateToday() {
        log.debug("Generate unique string with prefix: '{}'", generateTwoDigitsRandom());
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssSSSS");

        return generateTwoDigitsRandom() + ft.format(dNow);
    }
}
