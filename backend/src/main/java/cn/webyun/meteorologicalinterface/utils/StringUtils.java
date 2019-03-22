package cn.webyun.meteorologicalinterface.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static String escapeSQL(String str) {
        String escape = str;

        escape = escape.replace("'", "\\'");
        escape = escape.replace("\"", "\\\"");
        escape = escape.replace("%", "\\%");
        escape = escape.replace("_", "\\_");
        escape = escape.replace("[", "\\[");
        escape = escape.replace("]", "\\]");

        //logger.info("escape string: " + escape);

        return escape;
    }

    public static String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String getCurrentYear() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));
    }
}
