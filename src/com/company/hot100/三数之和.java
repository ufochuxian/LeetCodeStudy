package com.company.hot100;

import java.util.*;

public class 三数之和 {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        //对数组进行排序
        Arrays.sort(nums);

        //双指针解法

        List<List<Integer>> resList = new ArrayList<>();

        Map<String,String> regxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int front = i + 1;
            int back = nums.length - 1;

            //tips:三数之和有个小窍门就是 a + b + c = 0,可以转换为 a + b = -c，这样的话就相当于两数之和了，只不过这里的target不是固定的，是动态的
            //这里就有点类似于两数之和啦
            while (front < back) {
                //通过num[front] + num[back]的和与target进行比较，来判断进行双指针的移动
                if (nums[front] + nums[back] < target) {
                    //因为数组按升序排过顺序啦,所以当小于target的时候，左指针进行往右移动
                    front++;
                } else if (nums[front] + nums[back] > target) {
                    //因为数组按升序排过顺序啦,所以当大于target的时候，右指针往左边进行移动
                    back--;
                } else {
                    //当等于target的时候，说明就是我们需要需找的情况
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[front]);
                    list.add(nums[back]);
                    String str = String.valueOf(nums[i]) + String.valueOf(nums[i]) + String.valueOf(nums[back]);

                    if (!regxMap.containsKey(str)) {
                        regxMap.put(str, str);
                        resList.add(list);
                    }
                    front++;
                }
            }
        }
        return  resList;
    }
}
