package com.company;

import java.util.HashMap;
import java.util.Map;

public class UnRepeatString {


    public static void main(String[] args) {

        String s = s = "abcabcbb";

        int ans = lengthOfLongestSubstring(s);

        System.out.println(ans);

    }


    //https://www.bilibili.com/video/BV1bS4y1R7Ei?from=search&seid=18109393490969440453&spm_id_from=333.337.0.0
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        //使用滑动窗口，双指针结合一个队列来进行解决
        if (n == 1) {
            return 1;
        }

        Map<Character, Integer> char2IDMap = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            //如果队列中，已经存在了这个字符，那么说明出现重复的了，左指针需要往右移动一位
            if (char2IDMap.containsKey(ch)) {
                //这里利用了map为key,value的存储结构，可以记录字符出现的顺序为value的特性,从而将每个字符都绑定一个位置关系
                //很方便的就可以获取到位置，这里也是一样的,如果后面再次出现同样的字符的话,left也只能左边移动，不能向右边移动
                left = Math.max(left,char2IDMap.get(ch) + 1);
            }
            char2IDMap.put(ch, i);
            //ans 因为数字有可能之前出现过，后面又出现了，因为这里要统计最长字符串，所以这里ans只能变大，不能变小
//            ans = i - left + 1; abcabcbb 这里如果是这种的话，因为b后面又出现过好多次，会导致left变大，从而ans变小，所以这种情况要排除
            ans = Math.max(ans,i - left + 1);
        }
        return ans;
    }


}
