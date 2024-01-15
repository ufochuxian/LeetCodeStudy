package com.company.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap();

        int left = 0;
        int max = 0;
        for(int i =0; i < chars.length;i++) {

            //当滑动窗口的过程中出现了重复的字符的时候，需要提前前一个出现的字符，并且让其移出去
            if(map.containsKey(chars[i])) {
                left = Math.max(left,map.get(chars[i]) + 1);
            }
            map.put(chars[i],i);
            max = Math.max(max,i - left + 1);
        }

        return max;
    }

}
