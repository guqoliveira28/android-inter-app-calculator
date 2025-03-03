package com.example.calculatorclient.utils;

public class StringArrayUtils {
    public static int indexOfString(String[] strings, String target) {
        if (strings == null || target == null) {
            return -1;
        }

        for (int i = 0; i < strings.length; i++) {
            if (target.equalsIgnoreCase(strings[i])) {
                return i;
            }
        }

        return -1;
    }
}
