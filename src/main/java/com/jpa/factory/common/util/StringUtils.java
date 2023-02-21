package com.jpa.factory.common.util;

/**
 * packageName    : com.jpa.factory.common.util
 * fileName       : StringUtils
 * author         : 오주담
 * date           : 2022-12-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */
public class StringUtils {

    public static boolean isNull(String str) {
        return str == null || str.length() == 0;
    }

    public static String objToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return String.valueOf(obj);
        }
    }
}
