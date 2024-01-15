package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 ，LeetCode第一题
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum01 {

    /**
     * 解法：
     * 1. 定义一个map用于存放找到的数，以及其对应的下标。这里使用了map.contains这个函数，因为需要返回的是下标。
     * 所以这里有个小技巧，是把找到的数作为key,然后index作为value机型存储，这样就可以直接使用map.contains这个函数啦
     * <p>
     * 2. 遍历数组的每个元素，然后使用target与每个数进行相减，再进行判断这个相减的result在数组中是否存在
     * <p>
     * 3. 如果存在的话，那么当前的num[i]就是其中一个，i就是一个下标
     * <p>
     * 4. 因为如果不存在的话，我们会把当前的数字的值作为key，然后index作为value进行存储。
     * 所以在步骤三种，我们就可以直接使用map.get[resultNum]获取到对应的另一个的index
     *
     * @return
     */


    public static void main(String[] args) {

        int target = 9;
        int[] array = new int[]{2, 11, 10, 97,7};

        int[] findNumsResult = getTwoSum(target, array);

        for (int i = 0; i < findNumsResult.length; i++) {
            System.out.println("num:" + findNumsResult[i]);
        }

    }


    public static int[] calculateTwoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int resultNum = target - nums[i];

            if (map.containsKey(resultNum)) {
                //如果差值在数组中存在，那么说明就是当前的数以及那个在数组中出现的差值的数
                return new int[]{map.get(resultNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    public static int[] getTwoSum(int target, int[] arrays) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arrays.length; i++) {
            int current = arrays[i];
            int diff = target - current;
    
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(current, i);
            }
        }
        return null;
    }


}
