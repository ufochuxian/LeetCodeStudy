package com.company.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {

        String s = "cbaebabacd";

        String p = "abc";

        List<Integer> anagrams = findAnagrams(s, p);

        System.out.println(anagrams.toString());

    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList();

        char[] pChar = p.toCharArray();

        int startIndex = 0;

        int endIndex = pChar.length - 1;

        List<Character> slideWindowList = new ArrayList();

        List<Character> pCharList = new ArrayList();

        for (int i = 0; i < pChar.length; i++) {
            pCharList.add(pChar[i]);
        }

        Collections.sort(pCharList);

        for (int i = 0; i < s.length(); i++) {
            if (endIndex > s.length() - 1) {
                return res;
            }
            startIndex = i;
            while (startIndex <= endIndex) {
                slideWindowList.add(s.charAt(startIndex));
                startIndex++;
            }
            Collections.sort(slideWindowList);
            if (slideWindowList.toString().equals(pCharList.toString())) {
                res.add(i);
            }
            slideWindowList.clear();
            endIndex += 1;
        }
        return res;
    }
}
