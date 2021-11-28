package ru.mrKefir.stty.utils;

public final class ExitCondition {
    public static final String PATTERN = "Пока";


    public static boolean match(String buffer) {
        return buffer.trim().equals(PATTERN);
    }
}
