package pl.com.worktime.web.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    private static final DateTimeFormatter YEAR_MONHT_FORMATTER = DateTimeFormatter.ofPattern("yyyy MMMM", Locale.US);
    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH:mm", Locale.US);

    public static String getYearAndMonthName(LocalDate date) {
        return YEAR_MONHT_FORMATTER.format(date);
    }

    public static String getHourName(LocalDateTime time) {
        return HOUR_FORMATTER.format(time);
    }

    public static String getDayNumber(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }
}
