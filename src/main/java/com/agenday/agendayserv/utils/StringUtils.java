package com.agenday.agendayserv.utils;

import java.lang.String;

public class StringUtils {
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static String remove(String value, String target) {
        return value.replace(target, "");
    }
}