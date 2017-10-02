package pl.com.worktime.web.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Consumer;

public class DateUtil {

    public static final int HOURS_OF_DAY = 24;

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

    public static void iterateOverHoursOfTheDay(Consumer<LocalDateTime> consumer) {
        LocalDateTime dayTime = LocalDateTime.MIN;
        for (int i = 0; i < HOURS_OF_DAY; i++) {
            consumer.accept(dayTime.plusHours(i));
        }
    }

    public static void iterateOverDaysOfMonth(LocalDate month, Consumer<LocalDate> consumer) {
        LocalDate day = month.withDayOfMonth(1);
        for (int i = 0; i < month.lengthOfMonth(); i++) {
            consumer.accept(day.plusDays(i));
        }
    }
}
