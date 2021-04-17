package com.company;

public class ReverseString {

    /**
     *
     * 反转字符串
     * @param args
     */

    public static void main(String[] args) {

       System.out.println( reversString("abcdefg"));

    }

    public static String reversString(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
