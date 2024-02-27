package com.gigtoday.api.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GigDateUtils {

    public static final LocalDateTime now = LocalDateTime.now();
    public static final LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);


    private static final String dateTimeDelimiter = "'T'";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static LocalDateTime of(String date, String time) {
        return LocalDateTime.parse(date + dateTimeDelimiter + time, dateFormatter);
    }
}
