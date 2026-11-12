package org.jcc.util;

public class BirthDay {
    public static String format(String birthDay) {
        return birthDay.substring(0, 2) + "/" + birthDay.substring(2, 4) + "/" + birthDay.substring(4, 8);
    }
}
