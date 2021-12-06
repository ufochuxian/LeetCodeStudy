package com.company;

import java.util.PriorityQueue;

public class KMax {

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kMaxValue = findKMaxValue(nums, 4);

        System.out.println(kMaxValue);

    }

    private static int findKMaxValue(int nums[], int k) {
        //PriorityQueue的底层数据结构是堆，会按照元素的自然排序进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //最小堆

        //这里利用了PriorityQueue的结构会自然排序的特性
        //这类因为要维持堆的大小为K的过程，所以时间复杂度为OnLogN
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();

    }


}
