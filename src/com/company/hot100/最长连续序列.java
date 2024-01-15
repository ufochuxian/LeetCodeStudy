package com.company.hot100;

import java.util.HashSet;

public class 最长连续序列 {

    //题目讲解 https://www.youtube.com/watch?v=sti18kxeg9Q

    public static void main(String[] args) {

        int[] nums = new int[]{100,4,200,1,3,2};
        int res = longestConsecutive(nums);
        System.out.println(res);

    }

    public static int longestConsecutive(int[] nums) {

        // 1. 去重复数字
        HashSet<Integer> set = new HashSet();
        for(int num : nums) {
            set.add(num);
        }
        int res = 0;
        // 2. 遍历循环，判断set中包不包含当前遍历的数字的x的x+1和x-1,结束的条件就是两边都不包含啦
        for(int num : nums) {

            int down = num - 1;
            while(set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = num + 1;
            while(set.contains(up)) {
                set.remove(up);
                up++;
            }
            // 3. 获取结果 (这里因为在循环的过程中，会有多次的比价值，所以res需要记录最大的那个值)
            res = Math.max(res,up - down - 1);
        }
        return res;
    }
}
