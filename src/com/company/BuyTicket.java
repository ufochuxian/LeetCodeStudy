package com.company;

public class BuyTicket {

    //我们来假设自己来购买股票。随着时间的推移，每天我们都可以选择出售股票与否。那么，假设在第 i 天，如果我们要在今天卖股票，那么我们能赚多少钱呢？
    //显然，如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};


        System.out.println(calBuyTicket(nums));
    }


    private static int calBuyTicket(int[] nums) {
        //数组中购买的最小单价
        int minPrice = Integer.MAX_VALUE;
        //能够获得的最大利润
        int maxProfit = 0;
        //最佳时机
        int bestDay = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                //遍历过程中，不断比较，替换单价最低的数值
                minPrice = nums[i];
            } else if (nums[i] - minPrice > maxProfit) {
                //遍历过程中，不断计算当前最大利润和maxProfix的比较，进行对比
                maxProfit = nums[i] - minPrice;
                bestDay = i;
            }
        }
        return bestDay + 1;
    }


}
