package com.company;

public class DeepestCycleString {


    public static void main(String[] args) {
        String str = "babad";
        palindrome(str);
    }

    public static void palindrome(String str) {
        if (str == null || str.length() == 0)
            return;
        //如果str为null 或长度为0直接返回。
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        //对给出的串进行填充。
        sb.append("#");

        char chs[] = sb.toString().toCharArray();
        int max_len = 0;
        for (int i = 0; i < chs.length; i++) {
            //遍历到位置i时，对i进行中心扩展
            max_len = Math.max(subpalidromelen(chs, i), max_len);
            //subpalidromelen(chs,i),以i为中心进行中心扩展，max_len 保存最长回文子串的长度。
        }
        System.out.println(max_len);
    }

    //中心扩展函数
    public static int subpalidromelen(char[] chs, int i) {

        int len = 0;

        for (int k = 0; k <= i && k < (chs.length - i); k++) {
            if (chs[i - k] == chs[i + k]) {
                len++;

            } else {
                break;
            }
        }

        return len - 1;
        //因为是填充之后的串，填充之前的回文子串值为len-1。
    }
}
