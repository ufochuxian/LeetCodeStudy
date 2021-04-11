package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int UNFIND = -1;

    public static void main(String[] args) {
        // write your code here

        int[] array2 = new int[]{28, 30, 10, 15, 14, 8, 90};

        sort(array2);
    }


    //1. 选择排序
    public static int selectionSort(int[] array) {
        if (array == null || array.length < 0) {
            return UNFIND;
        }

        int minPos = 0;
        int temp;
        for (int i = 0; i < array.length; i++) {
            //进行数组长度额次数的轮次
            minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    //1. 更换当前最小变量的位置
                    minPos = j;
                }
            }
            //2. 进行交换
            temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;

        }
        for (int x = 0; x <= array.length - 1; x++) {
            System.out.print(array[x] + " ");
        }

        return minPos;
    }


    //选择排序
    public static void sort(int[] array) {

        int minPos;
        for (int i = 0; i < array.length; i++) {
            minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            //swap
            int temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }

        for (int x = 0; x <= array.length - 1; x++) {
            System.out.print(array[x] + " ");
        }

    }

}
