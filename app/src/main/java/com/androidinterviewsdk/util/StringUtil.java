package com.androidinterviewsdk.util;

public final class StringUtil {


    /**
     * Helper function for null and empty string testing.
     *
     * @return true iff s == null or s.equals("");
     */
    public static boolean isEmpty(String s) {
        return makeSafe(s).length() == 0;
    }

    /**
     * Helper function for making null strings safe for comparisons, etc.
     *
     * @return (s == null) ? "" : s;
     */
    public static String makeSafe(String s) {
        return (s == null) ? "" : s;
    }
}
