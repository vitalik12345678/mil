package com.data.mil.utils;

public interface PhoneUtil {

    static String ukrPhoneFormat(String number) {
        return String.format("+38(%s) %s %s %s", number.substring(0, 3), number.substring(3, 6), number.substring(6, 8), number.substring(8, 10));
    }

}
